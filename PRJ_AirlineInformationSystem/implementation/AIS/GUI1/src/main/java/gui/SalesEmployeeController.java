package gui;

import businessLogic.BookingManagerImpl;
import businessLogic.BusinessLogicFactoryImpl;
import businessLogic.FlightServiceImpl;
import datarecords.BookingData;
import datarecords.FlightData;
import datarecords.PassengerData;
import datarecords.SeatData;
import gui.Utility.FlightDataSaver;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class SalesEmployeeController implements Initializable {

    BookingManagerImpl bookingManager = BusinessLogicFactoryImpl.createBookingManager();

    FlightServiceImpl flightService = BusinessLogicFactoryImpl.createFlightService();

    public Label seatNumber;
    public CheckBox foodOption;
    public CheckBox legroomOption;
    public CheckBox luggageOption;

    // alert object for showing an error if something went wrong
    Alert alert = new Alert(Alert.AlertType.ERROR);


    public void onBackButtonClick(ActionEvent actionEvent) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScene(SceneManager.SceneType.FIRST_SCENE);
    }

    @FXML
    public VBox createNewBookingContent;
    @FXML
    public VBox createNewPassengerContent;
    @FXML
    private ComboBox<String> numberOfPassengers;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField seat;

    @FXML
    private TextField passportNumber;


    // for showing flights

    @FXML
    TableView<FlightDataSaver> flightTableView;

    @FXML
    private TableColumn<FlightDataSaver, String> flightNumberColumn;

    @FXML
    private TableColumn<FlightDataSaver, LocalTime> departure;

    @FXML
    private TableColumn<FlightDataSaver, LocalTime> arrival;

    @FXML
    private TableColumn<FlightDataSaver, LocalDate> departureDate;

    @FXML
    private TableColumn<FlightDataSaver, LocalDate> arrivalDate;

    @FXML
    private TableColumn<FlightDataSaver, String> departureAirport;

    @FXML
    private TableColumn<FlightDataSaver, String> arrivalAirport;

    @FXML
    private TableColumn<FlightDataSaver, String> airplaneRegistrationNumber;


    private final String[] nrOfPassengers = {"1", "2", "3"};

    ObservableList<FlightDataSaver> contentsFlight;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberOfPassengers.getItems().addAll(Arrays.asList(nrOfPassengers));
        numberOfPassengers.setPromptText("Select Number of Passengers");
        getAllFLightsOnTable();


    }

    public void showCreateNewBooking() {
        createNewBookingContent.setVisible(true);
        createNewPassengerContent.setVisible(false);
        searchBookingContent.setVisible(false);
    }

    FlightDataSaver selectedFlight;
    String selectedPassengers;

     List<Integer> seatNumbers = new ArrayList<>();

    //= ;
    public synchronized void onCreateBookingButtonClick(ActionEvent actionEvent) {
        selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        selectedPassengers = numberOfPassengers.getSelectionModel().getSelectedItem();

        //  boolean isBookingExists = false;

        // Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        if (selectedFlight == null) {
            alert.setContentText("Please select a flight!!");
            alert.showAndWait();
            return;
        }

        if (selectedPassengers == null) {
            alert.setContentText("Please select at least one passenger!!");
            alert.showAndWait();
            return;
        }


        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime departureDateTime = LocalDateTime.of(selectedFlight.getDepartureDate(), selectedFlight.getDeparture());

        if (departureDateTime.isBefore(currentDateTime)) {
            alert.setContentText("please select a flight that s in the future!!");
            alert.showAndWait();
            return;
        }

        String airplaneRegistrationNumber = selectedFlight.getAirplaneNumberRegistration();
        int numberOfPassengers = Integer.parseInt(selectedPassengers);


        synchronized (this) {

            boolean isSeatAvailable = bookingManager.isSeatAvailable(airplaneRegistrationNumber, numberOfPassengers);


            // check seat avialbility
            // if seat availability is free enough regarding the nr of pass selected and the available seats
            // then generate a random seat that is not already taken/ in the database as a booked seat.

            //  isBookingExists = bookingManager.isBookingExists(selectedFlight.getFlightNumbers(),selectedFlight.getDepartureDate());


            if (isSeatAvailable == true) {


                createNewBookingContent.setVisible(false);
                createNewPassengerContent.setVisible(true);
                BookingData bookingData = new BookingData(selectedFlight.getFlightNumbers(), Integer.parseInt(selectedPassengers));

                try {
                    bookingManager.addBooking(bookingData);
                } catch (Exception e) {
                    Alert alertEr = new Alert(Alert.AlertType.ERROR);

                    alertEr.setContentText(e.getMessage());
                    alertEr.show();
                }


            } else {
                alert.setContentText("there are not enough seats");
                alert.showAndWait();
            }
        }

    }
    SeatData seatData;

    PassengerData passengerData;
//int counter = 0;

    public void onCreatePassengerButtonClick(ActionEvent actionEvent) {

        int price = 0;

        int counter = 0;

        int nrOfPassengers = Integer.parseInt(selectedPassengers);



        seatNumbers.clear();

        boolean isBookingExistsForPassenger = false;



        for (int i = 0; i < nrOfPassengers; i++) {

            String selectedAirplaneRegistrationNumber = selectedFlight.getAirplaneNumberRegistration();
            int nrOfTotalSeats = bookingManager.getNrOfTotalSeatsForSelectedFlight(selectedAirplaneRegistrationNumber);
            seatNumbers.add(bookingManager.generateSeatNumber(nrOfTotalSeats, selectedAirplaneRegistrationNumber));

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Booking Confirmation");

            // Create content for the dialog
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            TextField firstName = new TextField();
            TextField lastName = new TextField();
            TextField passportNumber = new TextField();
            Label seatNumber = new Label();

            CheckBox foodOption = new CheckBox("Food");
            CheckBox luggageOption = new CheckBox("Luggage");
            CheckBox legroomOption = new CheckBox("Legroom");

            gridPane.addRow(0, new Label("First Name:"), firstName);
            gridPane.addRow(1, new Label("Last Name:"), lastName);
            gridPane.addRow(2, new Label("Passport Number:"), passportNumber);
            gridPane.addRow(3, foodOption);
            gridPane.addRow(4, luggageOption);
            gridPane.addRow(5, legroomOption);
            gridPane.addRow(6, new Label("Seat number: " + seatNumbers.get(i)));
            //  seatNumber.setText("Seat number: " + bookingManager.generateRandomSeatNumber()) );

            dialog.getDialogPane().setContent(gridPane);

            // Add buttons to the dialog
            ButtonType confirmButton = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(confirmButton, cancelButton);

            // Wait for the user to click a button
            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == confirmButton) {
                // User clicked "Confirm"
                // Check if passport number contains only numbers


                if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || passportNumber.getText().isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("All fields need to be completed.");
                    alert.showAndWait();
                } else {
                    if (!passportNumber.getText().matches("\\d+")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Passport number should contain only numbers.");
                        alert.showAndWait();

                    } else {


                        boolean food = foodOption.isSelected();
                        boolean luggage = luggageOption.isSelected();
                        boolean legroom = legroomOption.isSelected();

                        seatData = new SeatData(seatNumbers.get(i), food, legroom, luggage, selectedAirplaneRegistrationNumber);
                        passengerData = new PassengerData(firstName.getText(), lastName.getText(), passportNumber.getText());

                        isBookingExistsForPassenger = bookingManager.isBookingExistsForPassenger(firstName.getText(), lastName.getText(), passportNumber.getText());

                        if (isBookingExistsForPassenger == false) {

                            try {
                                bookingManager.addPassengersAndSeat(seatData, passengerData);
                            } catch (Exception e) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("The passenger and seat insert failed!");
                                alert.showAndWait();

                            }

                            // Clear the fields and reset options
                            firstName.clear();
                            lastName.clear();
                            passportNumber.clear();

                            foodOption.setSelected(false);
                            legroomOption.setSelected(false);
                            luggageOption.setSelected(false);


                           price = price + bookingManager.calculatePrice(food,legroom,luggage,100);


                            Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
                            confirmationAlert.setHeaderText("Passenger Confirmation");
                            confirmationAlert.setContentText("passenger was added.\n\n" + seatData.toString() + "\n" + passengerData.toString());
                            confirmationAlert.showAndWait();


                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Cannot add the same passenger ");
                            alert.showAndWait();
                        }


//
                        counter++;
                    }
                }
                // Check for fields to be all completed or else show an error message
            }
        }


        if (counter == nrOfPassengers && isBookingExistsForPassenger == false) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("booking was created. Price is: "+ price+" euro");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("booking was not created.");
            alert.showAndWait();
        }
        // Display the booking confirmation


        createNewBookingContent.setVisible(true);
        createNewPassengerContent.setVisible(false);


    }


    /**
     * gets all flights and put them in the table
     */
    public void getAllFLightsOnTable() {

        try {


            flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumbers"));
            departure.setCellValueFactory(new PropertyValueFactory<>("departure"));
            arrival.setCellValueFactory(new PropertyValueFactory<>("arrival"));
            departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
            arrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
            departureAirport.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getDepartureAirportName()));

            arrivalAirport.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getArrivalAirportName()));
           // departureAirport.setCellValueFactory(new PropertyValueFactory<>("departureAirport"));


            List<FlightData> flights = flightService.getAllFlights();

            // Fetch and display the flight data in the table view

            List<FlightDataSaver> flightsForTable = flights.stream()
                    .map(FlightDataSaver::new).toList();

            ObservableList<FlightDataSaver> data = FXCollections.observableArrayList(flightsForTable);
            flightTableView.setItems(data);
        } catch (Exception e) {
            Alert alertEr = new Alert(Alert.AlertType.ERROR);
            alertEr.setTitle("No database connection");
            alertEr.setContentText("The insert has failed!");
            alertEr.show();
        }

    }
    @FXML
    public VBox searchBookingContent;

    @FXML
    private Button SearchBookingButton;
    public void onSearchBookingButtonClick(ActionEvent actionEvent) {
        createNewBookingContent.setVisible(false);
        createNewPassengerContent.setVisible(false);
        searchBookingContent.setVisible(true);
    }
    public void onSearchButtonClick(ActionEvent actionEvent) {
        // String bookingID = bookingIDField.getText();
        // Implement the logic to search the booking based on the provided bookingID
        // You can display the search results or perform any further actions here
    }


}
