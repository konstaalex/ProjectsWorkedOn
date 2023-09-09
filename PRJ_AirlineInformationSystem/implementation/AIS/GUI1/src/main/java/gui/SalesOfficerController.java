package gui;
import businessLogic.BusinessLogicAPIImpl;
import businessLogic.BusinessLogicFactoryImpl;
import businessLogic.FlightServiceImpl;
import com.calendarfx.view.CalendarView;
import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;
import gui.Utility.ErrorController;
import gui.Utility.FlightDataSaver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;



import static gui.Utility.ErrorController.allFieldsRequiredError;
import static gui.Utility.ErrorController.generalErrorWindow;

public class SalesOfficerController implements Initializable {

    @FXML
    public ComboBox<String> airplaneModelComboBox;
    public TextField airplaneModelField;
    public TextField airplaneRegistrationNumber;
    public DatePicker departureDatePicker;
    public TextField hourField;
    public TextField minuteField;
    public CheckBox dateRangeCheckbox;
    public VBox dateRangeBox;

    public DatePicker endPeriodDatePicker;
    public VBox createNewFlightCalendarContent;
    public GridPane calendar;
    public CalendarView calendarView;


    //fxml file fields for creating airport

    @FXML
    private TextField airportName;

    @FXML
    private TextField numberOfGates;

    @FXML
    private ComboBox<String> timezoneComboBox;

    @FXML
    private TextField latitude;

    @FXML
    private TextField longitude;


    private final String[] timezones = {
            "UTC-12:00", "UTC-11:00", "UTC-10:00", "UTC-09:30", "UTC-09:00", "UTC-08:00",
            "UTC-07:00", "UTC-06:00", "UTC-05:00", "UTC-04:30", "UTC-04:00", "UTC-03:30",
            "UTC-03:00", "UTC-02:00", "UTC-01:00", "UTC+00:00", "UTC+01:00", "UTC+02:00",
            "UTC+03:00", "UTC+03:30", "UTC+04:00", "UTC+04:30", "UTC+05:00", "UTC+05:30",
            "UTC+05:45", "UTC+06:00", "UTC+06:30", "UTC+07:00", "UTC+08:00", "UTC+08:45",
            "UTC+09:00", "UTC+09:30", "UTC+10:00", "UTC+10:30", "UTC+11:00", "UTC+12:00",
            "UTC+12:45", "UTC+13:00", "UTC+14:00"
    };


    // fxml files fields for airplane
    @FXML
    public VBox createNewAirplaneContent;
    @FXML
    public TextField engineTypeField;
    @FXML
    public TextField airplaneIDField;
    @FXML
    public TextField fuelConsumptionField;
    @FXML
    public TextField businessClassSeatsField;
    @FXML
    public TextField extraLegroomSeatsField;
    @FXML
    public TextField luggageCapacityField;
    @FXML
    TextField totalSeatsField;


    //fields for showing content on the screen

    @FXML
    private VBox createNewFlightContent;
    @FXML
    private VBox createNewAirportContent;

    @FXML
    private VBox showAllFLightsContentVar;


    //fxml file fields for the flight
    @FXML
    private TextField flightNumberField;

    @FXML
    private ComboBox<AirplaneData> airplaneComboBox;

    @FXML
    private ComboBox<AirportData> departureComboBox;

    @FXML
    private ComboBox<AirportData> arrivalComboBox;


    //fxml files for showing the flights on the table

    @FXML
    TableView<FlightDataSaver> flightTableView;

    @FXML
    private TableColumn<FlightDataSaver, String> flightNumberColumn;

    @FXML
    private TableColumn<FlightDataSaver, String> departureColumn;

    @FXML
    private TableColumn<FlightDataSaver, String> arrivalColumn;

    @FXML
    private TableColumn<FlightDataSaver, LocalDate> departureDateColumn;

    @FXML
    private TableColumn<FlightDataSaver, LocalDate> arrivalDateColumn;

    @FXML
    private TableColumn<FlightDataSaver, Integer> totalSeatsColumn;

    BusinessLogicAPIImpl businessLogicAPI;


    //Creating business logic
    FlightServiceImpl flightService = BusinessLogicFactoryImpl.createFlightService();


    public SalesOfficerController() {
    }

    //because it is javafx it is not possible to create new instance, that is why if the class is needed in the intialization this method is called.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //register airport window
        timezoneComboBox.getItems().addAll(Arrays.asList(timezones));
        timezoneComboBox.setPromptText("Select Timezone");
        getAllFlightsOnTable();

        dateRangeCheckbox.setOnAction(event -> {
            boolean isSelected = dateRangeCheckbox.isSelected();
            dateRangeBox.setVisible(isSelected);
        });

        //register flight window
        List<AirportData> airports = flightService.getAllAirports();
        List<AirplaneData> airplaneData = flightService.getAllAirplanes();
        Callback<ListView<AirportData>, ListCell<AirportData>> nameCellFactory = createComboBoxCellFactory(AirportData::name);

        departureComboBox.setCellFactory(nameCellFactory);
        arrivalComboBox.setCellFactory(nameCellFactory);
        departureComboBox.setButtonCell(nameCellFactory.call(null));
        arrivalComboBox.setButtonCell(nameCellFactory.call(null));
        departureComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Update the arrivalComboBox options based on the new departure airport
            List<AirportData> filteredAirports = airports.stream()
                    .filter(airport -> !airport.equals(newValue))
                    .collect(Collectors.toList());
            arrivalComboBox.getItems().clear();
            arrivalComboBox.getItems().addAll(filteredAirports);
        });
        departureComboBox.getItems().addAll(airports);
        arrivalComboBox.getItems().addAll(airports);

        //adding airplanes to the combobox
        Callback<ListView<AirplaneData>, ListCell<AirplaneData>> airplaneCellFactory = createComboBoxCellFactory(AirplaneData::airplaneRegistrationNumber);
        airplaneComboBox.setCellFactory(airplaneCellFactory);
        airplaneComboBox.setButtonCell(airplaneCellFactory.call(null));
        airplaneComboBox.getItems().addAll(airplaneData);

        flightNumberField.setPromptText("Enter flight number (4 digits)");
    }


    //To inject the FlightManager dependency into your FlightController


    @FXML
    public void onCreateFlightButtonClick(ActionEvent event) {

        int successfulRegistrations = 0;
        int failedRegistrations = 0;

        // Get the input values from the user interface components
        String flightNumber = "KL" + flightNumberField.getText();
        AirplaneData airplane = airplaneComboBox.getValue();
        AirportData departure = departureComboBox.getValue();
        AirportData arrival = arrivalComboBox.getValue();
        LocalDate departureDate = departureDatePicker.getValue();
        int hour = Integer.parseInt(hourField.getText());
        int minute = Integer.parseInt(minuteField.getText());
        LocalTime departureTime = LocalTime.of(hour, minute);

        // Validate the input values and make sure they are not null or empty
        if (flightNumber.isEmpty() || airplane == null || departure == null || arrival == null || departureDate == null || hourField == null || minuteField == null) {
            allFieldsRequiredError();
            return;
        }
        if (!flightNumber.matches("KL\\d+")) {
            ErrorController.generalErrorWindow("Flight number should start with KL and contain only digits.");
            return;
        }
        LocalDate currentDate = LocalDate.now();
        if (departureDate.isBefore(currentDate)) {
            ErrorController.generalErrorWindow("Departure date cannot be in the past.");
            return;
        }

        DayOfWeek selectedDayOfWeek = departureDate.getDayOfWeek();
        LocalDate endDate;
        LocalDate startDate;

        //TODO fix custom period selection
        if (dateRangeCheckbox.isSelected()) {
            endDate = endPeriodDatePicker.getValue();
            if (endDate == null || endDate.isBefore(departureDate)) {
                ErrorController.generalErrorWindow("Please enter a valid end date for the custom scheduling period.");
                return;
            }
        } else {
            endDate = departureDate.plusMonths(6);
        }

        while (departureDate.isBefore(endDate)) {
            if (departureDate.getDayOfWeek() == selectedDayOfWeek) {

                if (flightService.isAirplaneScheduled(airplane, departureDate, departureTime,departure)) {
                    ErrorController.generalErrorWindow("The selected airplane is already scheduled for the specified departure date and time.");
                    return;
                }

                // Get the list of airports and find the departure and arrival airports
                List<AirportData> airports = flightService.getAllAirports();
                AirportData departureAirport = null;
                AirportData arrivalAirport = null;
                for (AirportData airport : airports) {
                    if (airport.name().equals(departure.name())) {
                        departureAirport = airport;
                    }
                    if (airport.name().equals(arrival.name())) {
                        arrivalAirport = airport;
                    }
                    if (departureAirport != null && arrivalAirport != null) {
                        break;
                    }
                }

                // Get the latitude and longitude of the departure and arrival airports
                double departureLat = departureAirport.latitude();
                double departureLon = departureAirport.longitude();
                double arrivalLat = arrivalAirport.latitude();
                double arrivalLon = arrivalAirport.longitude();

                // Calculate the distance between the departure and arrival airports
                double distance = flightService.calculateDistance(departureLat, departureLon, arrivalLat, arrivalLon);
                LocalTime arrivalTime = flightService.arrivalTimeCalculator(distance, departureTime ,arrivalAirport, departureAirport);

//               LocalTime arrivalTime = departureTime.plusHours((long) duration);
                LocalDate arrivalDate = departureDate;
                if (arrivalTime.isBefore(departureTime)) {
                    arrivalDate = arrivalDate.plusDays(1);
                }

                List<Integer> gates = flightService.gateNumbers(arrivalAirport);
                boolean isFlightRegistered = false;

                for (int gateNumber : gates) {
                    if (flightService.gateAvailability(arrivalAirport, departureDate, arrivalTime, gateNumber)) {
                        // if gate available then register succesffuly the flight
                        FlightData flightData = new FlightData(flightNumber, departureAirport, arrivalAirport, departureDate, departureTime, arrivalDate, arrivalTime, airplane, gateNumber);
                        flightService.registerFlight(flightData);
                        //ErrorController.successWindow("Flight was successfully registered");
                        flightNumberField.clear();
                        airplaneComboBox.setValue(null);
                        departureComboBox.setValue(null);
                        arrivalComboBox.setValue(null);
                        minuteField.clear();
                        hourField.clear();
                        departureDatePicker.setValue(null);
                        isFlightRegistered = true;
                        successfulRegistrations++;

                        break;
                    }
                }
                if (!isFlightRegistered) {
                    failedRegistrations++;
                }

            }
            departureDate = departureDate.plusDays(1); // Increment the departureDate
        }
        if (successfulRegistrations > 0) {
            ErrorController.successWindow(successfulRegistrations + " flight(s) were successfully registered.");
            flightNumberField.clear();
            airplaneComboBox.setValue(null);
            departureComboBox.setValue(null);
            arrivalComboBox.setValue(null);
            minuteField.clear();
            hourField.clear();
            departureDatePicker.setValue(null);
        }
        if (failedRegistrations > 0) {
            ErrorController.generalErrorWindow(failedRegistrations + " flight(s) could not be registered due to occupied gates.");
        }
    }

        public void getAllFlightsOnTable () {
//        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
//        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
//        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
//        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
//        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
//        totalSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("totalSeats"));
//
//        List<FlightData> flights = flightManager.getAllFlights();
//
//        // Fetch and display the flight data in the table view
//
//        List<FlightDataSaver> flightsForTable = flights.stream()
//                .map(FlightDataSaver::new).toList();
//
//        ObservableList<FlightDataSaver> data = FXCollections.observableArrayList(flightsForTable);
//        flightTableView.setItems(data);
        }

        public void onBackButtonClick (ActionEvent actionEvent){
            SceneManager sceneManager = SceneManager.getInstance();
            sceneManager.changeScene(SceneManager.SceneType.FIRST_SCENE);
        }



        public void onCreateAirportButtonClick (ActionEvent actionEvent){
            if (airportName.getText().isEmpty() || this.numberOfGates.getText().isEmpty() || this.timezoneComboBox == null || latitude.getText().isEmpty() || longitude.getText().isEmpty()) {
                allFieldsRequiredError();
                return;
            }

            String airportName = this.airportName.getText();
            int numberOfGates = Integer.parseInt(this.numberOfGates.getText());
            String timezoneString = timezoneComboBox.getValue();
            double latitude = Double.parseDouble(this.latitude.getText());
            double longitude = Double.parseDouble(this.longitude.getText());


            ZoneId timezone = ZoneId.of(timezoneString);
            List<AirportData> airports = flightService.getAllAirports();
            boolean airportAlreadyRegistered = false;
            for (AirportData airport : airports) {
                if (airportName.equals(airport.name())) {
                    airportAlreadyRegistered = true;
                    generalErrorWindow("This airport is already registered");
                    break; // break the loop as the airport is already registered
                }
            }
            if (airportAlreadyRegistered) {
                return; // do not register the airport
            }

            AirportData airportData = new AirportData(airportName, numberOfGates, timezone, latitude, longitude);
            flightService.registerAirport(airportData);
            ErrorController.successWindow("Airport added successfully to the system");

            this.airportName.clear();
            this.numberOfGates.clear();
            timezoneComboBox.setValue(null);
            this.latitude.clear();
            this.longitude.clear();
        }


        public void onCreateAirplaneButtonClick (ActionEvent actionEvent){

            if (airplaneModelField.getText().isEmpty() || airplaneRegistrationNumber.getText().isEmpty() || fuelConsumptionField.getText().isEmpty() || totalSeatsField.getText().isEmpty() || businessClassSeatsField.getText().isEmpty() || extraLegroomSeatsField.getText().isEmpty() || luggageCapacityField.getText().isEmpty()) {
                allFieldsRequiredError();
                return;
            }

            try {
                String airplaneModel = airplaneModelField.getText();
                String airplaneRegistrationNumberText = airplaneRegistrationNumber.getText();
                double fuelConsumption = Double.parseDouble(fuelConsumptionField.getText());
                int totalSeats = Integer.parseInt(totalSeatsField.getText());
                int businessClassSeats = Integer.parseInt(businessClassSeatsField.getText());
                int extraLegroomSeats = Integer.parseInt(extraLegroomSeatsField.getText());
                int luggageCapacity = Integer.parseInt(luggageCapacityField.getText());

                AirplaneData airplaneData = new AirplaneData(airplaneModel, airplaneRegistrationNumberText, fuelConsumption, businessClassSeats, extraLegroomSeats, totalSeats, luggageCapacity); // Pass totalSeats here
                flightService.registerAirplane(airplaneData);
                ErrorController.successWindow("Airplane added successfully to the system");

                airplaneModelField.clear();
                airplaneRegistrationNumber.clear();
                fuelConsumptionField.clear();
                totalSeatsField.clear();
                businessClassSeatsField.clear();
                extraLegroomSeatsField.clear();
                luggageCapacityField.clear();

            } catch (IllegalArgumentException e) {
                ErrorController.generalErrorWindow(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //methods that are showing the content on the fxml file
        @FXML
        private void showCreateNewFlightContent () {
            createNewFlightContent.setVisible(true);
            createNewAirportContent.setVisible(false);
            showAllFLightsContentVar.setVisible(false);
            createNewAirplaneContent.setVisible(false);
            createNewFlightCalendarContent.setVisible(false);
        }

        @FXML
        private void showCreateNewAirportContent () {
            createNewAirportContent.setVisible(true);
            createNewFlightContent.setVisible(false);
            showAllFLightsContentVar.setVisible(false);
            createNewAirplaneContent.setVisible(false);
            createNewFlightCalendarContent.setVisible(false);

        }

        @FXML
        private void showAllFlightsContent () {
            showAllFLightsContentVar.setVisible(true);
            createNewFlightContent.setVisible(false);
            createNewAirportContent.setVisible(false);
            createNewAirplaneContent.setVisible(false);
            createNewFlightCalendarContent.setVisible(false);
        }

        public void showCreateNewAirplaneContent (ActionEvent actionEvent){
            createNewAirplaneContent.setVisible(true);
            showAllFLightsContentVar.setVisible(false);
            createNewFlightContent.setVisible(false);
            createNewAirportContent.setVisible(false);
            createNewFlightCalendarContent.setVisible(false);
        }

    public void showCalendarFLightContent(ActionEvent actionEvent) {
        createNewAirplaneContent.setVisible(false);
        showAllFLightsContentVar.setVisible(false);
        createNewFlightContent.setVisible(false);
        createNewAirportContent.setVisible(false);
        createNewFlightCalendarContent.setVisible(true);
    }
// this helper method is needed, as default population of the combobox is only inserting toString
        //I did not wanted to show toString, but only some part of the object and that is why this method is needed
        //this method is reusable, as before it was needed to create each new method for a new population as it were diffrent objects.
    //make utility class
        public static <
        T > Callback < ListView < T >, ListCell < T >> createComboBoxCellFactory(Function < T, String > propertyGetter)
        {
            return new Callback<>() {
                @Override
                public ListCell<T> call(ListView<T> param) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(T item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null);
                            } else {
                                setText(propertyGetter.apply(item));
                            }
                        }
                    };
                }
            };
        }





}




