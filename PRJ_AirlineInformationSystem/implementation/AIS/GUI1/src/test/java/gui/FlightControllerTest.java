package gui;
import businessLogic.BusinessLogicFactoryImpl;
import businessLogic.FlightServiceImpl;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.robot.Motion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class FlightControllerTest {
    SalesOfficerController flightController = new SalesOfficerController();
    FlightServiceImpl businessLogic = BusinessLogicFactoryImpl.createFlightService();


    @BeforeAll
    public static void initToolkit() {
        // Initialize JavaFX
        try {
            Platform.startup(() -> {
            });
        } catch (Exception e) {
            // ignore already initialized exception
        }
    }

    @Start
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sales-officer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    //registration of the default period flight
    @Test
    public void testRegisterFlight (FxRobot robot) throws IOException {
        Random random = new Random();

        //clicking to make content visible
        robot.clickOn("#createNewFlightButton");
        // Generate a random 4-digit number to use as the flight number
        Random rand = new Random();
        int flightNumber = rand.nextInt(9000) + 1000; // generate a number between 1000 and 9999
        String flightNumberStr = ""+flightNumber;

        robot.clickOn("#flightNumberField").write(flightNumberStr);

        robot.interact(() -> {
            ComboBox<String> airplaneComboBox = robot.lookup("#airplaneComboBox").queryComboBox();
            int itemCount = airplaneComboBox.getItems().size(); // Get the number of items in the ComboBox
            int randomIndex = random.nextInt(itemCount); // Generate a random index within the range of available items
            airplaneComboBox.getSelectionModel().select(randomIndex); // Select the random index
        });

        robot.interact(() -> {
            ComboBox<String> departureComboBox = robot.lookup("#departureComboBox").queryComboBox();
            int itemCount = departureComboBox.getItems().size(); // Get the number of items in the ComboBox
            int randomIndex = random.nextInt(itemCount); // Generate a random index within the range of available items
            departureComboBox.getSelectionModel().select(randomIndex); // Select the random index        });
        });

        robot.interact(() -> {
            ComboBox<String> arrivalComboBox = robot.lookup("#arrivalComboBox").queryComboBox();
            int itemCount1 = arrivalComboBox.getItems().size(); // Get the number of items in the ComboBox
            int randomIndex1 = random.nextInt(itemCount1); // Generate a random index within the range of available items
            arrivalComboBox.getSelectionModel().select(randomIndex1); // Select the random index
        });

        // Generate a random departure date between today and 30 days in the future
        Random random2 = new Random();
        int daysUntilDeparture = random2.nextInt(30); // generate a number between 0 and 29
        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = currentDate.plusDays(daysUntilDeparture);

        // Set the departure date in the user interface
        robot.clickOn("#departureDatePicker");
        robot.interact(() -> {
            DatePicker departureDatePicker = robot.lookup("#departureDatePicker").queryAs(DatePicker.class);
            departureDatePicker.setValue(departureDate);
        });
        // Generate random values for the hour and minute fields
        Random random3 = new Random();
        int hour = random3.nextInt(24);
        int minute = random3.nextInt(60);

        // Set the input values for the hour and minute fields
        robot.clickOn("#hourField").write(Integer.toString(hour));
        robot.clickOn("#minuteField").write(Integer.toString(minute));


        robot.clickOn("#createFlight");

        DialogPane successDialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        assertNotNull(successDialogPane);
        assertEquals("27 flight(s) were successfully registered.", successDialogPane.getHeaderText());
        robot.clickOn(".button:contains('ok')");

    }

    //registration of the flight with custom period
    @Test
    public void testRegisterFlightWithCustomPeriod (FxRobot robot) throws IOException {
        Random random = new Random();

        //clicking to make content visible
        robot.clickOn("#createNewFlightButton");
        // Generate a random 4-digit number to use as the flight number
        Random rand = new Random();
        int flightNumber = rand.nextInt(9000) + 1000; // generate a number between 1000 and 9999
        String flightNumberStr = "" + flightNumber;

        robot.clickOn("#flightNumberField").write(flightNumberStr);

        robot.interact(() -> {
            ComboBox<String> airplaneComboBox = robot.lookup("#airplaneComboBox").queryComboBox();
            int itemCount = airplaneComboBox.getItems().size(); // Get the number of items in the ComboBox
            int randomIndex = random.nextInt(itemCount); // Generate a random index within the range of available items
            airplaneComboBox.getSelectionModel().select(randomIndex); // Select the random index
        });

        robot.interact(() -> {
                    ComboBox<String> departureComboBox = robot.lookup("#departureComboBox").queryComboBox();
                    int itemCount = departureComboBox.getItems().size(); // Get the number of items in the ComboBox
                    int randomIndex = random.nextInt(itemCount); // Generate a random index within the range of available items
                    departureComboBox.getSelectionModel().select(randomIndex); // Select the random index        });
        });

        robot.interact(() -> {
            ComboBox<String> arrivalComboBox = robot.lookup("#arrivalComboBox").queryComboBox();
            int itemCount1 = arrivalComboBox.getItems().size(); // Get the number of items in the ComboBox
            int randomIndex1 = random.nextInt(itemCount1); // Generate a random index within the range of available items
            arrivalComboBox.getSelectionModel().select(randomIndex1); // Select the random index
            });

        LocalDate today = LocalDate.now();
        LocalDate sixMonthsLater = today.plusMonths(6);

            int year = sixMonthsLater.getYear() + random.nextInt(2); // Generating a random year between sixMonthsLater and one year after
            int month = random.nextInt(12) + 1; // Generating a random month (1-12)
            int dayOfMonth = random.nextInt(sixMonthsLater.lengthOfMonth()) + 1; // Generating a random day based on the month

            LocalDate departureDate = LocalDate.of(year, month, dayOfMonth);
            robot.interact(() -> {
                DatePicker departureDatePicker = robot.lookup("#departureDatePicker").queryAs(DatePicker.class);
                departureDatePicker.setValue(departureDate);
            });

            // Generate random values for the hour and minute fields
            Random random3 = new Random();
            int hour = random3.nextInt(24);
            int minute = random3.nextInt(60);

            // Set the input values for the hour and minute fields
            robot.clickOn("#hourField").write(Integer.toString(hour));
            robot.clickOn("#minuteField").write(Integer.toString(minute));

            robot.clickOn("#dateRangeCheckbox");


            int year1 = departureDate.getYear() + random.nextInt(2); // Generating a random year between departureDate and one year after
            int month1 = random.nextInt(12) + 1; // Generating a random month (1-12)
            int dayOfMonth1 = random.nextInt(YearMonth.of(year1, month1).lengthOfMonth()) + 1; // Generating a random day based on the month

            LocalDate endPeriod = LocalDate.of(year1, month1, dayOfMonth1);

            robot.interact(() -> {
                DatePicker endPeriodPicker = robot.lookup("#endPeriodDatePicker").queryAs(DatePicker.class);
                endPeriodPicker.setValue(endPeriod);
            });

            robot.clickOn("#createFlight");
            // Check if the success dialog is displayed
            DialogPane successDialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
            assertNotNull(successDialogPane);

            // Get the Stage containing the success dialog
            Stage successStage = (Stage) successDialogPane.getScene().getWindow();

            // Assert that the stage title is "Success"
            assertEquals("Success", successStage.getTitle());
            robot.clickOn(".button:contains('ok')");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "airportTest.csv")
    public void registerAirportTest (String airportName, int numberOfGates, String timezone, double latitude, double longitude, FxRobot robot){
        Random random = new Random();
        robot.clickOn("#registerAirportButton");
        robot.clickOn("#airportName").write(airportName);
        robot.clickOn("#numberOfGates").write(Integer.toString(numberOfGates));

        String selectedTimezone = timezone;

        robot.interact(() -> {
            ComboBox<String> timezoneComboBox = robot.lookup("#timezoneComboBox").queryComboBox();
            timezoneComboBox.getSelectionModel().select(selectedTimezone);
        });
        robot.clickOn("#latitude").write(Double.toString(latitude));
        robot.clickOn("#longitude").write(Double.toString(longitude));
        robot.clickOn("#submitButton");
        DialogPane successDialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        assertNotNull(successDialogPane);
        assertEquals("Airport added successfully to the system", successDialogPane.getHeaderText());
        robot.clickOn(".button:contains('OK')");
        
    }

    @Test
    public void registerAirportWhichisAlreadyRegistered (FxRobot robot){
        robot.clickOn("#registerAirportButton");
        robot.clickOn("#airportName").write("JFK");
        robot.clickOn("#numberOfGates").write("1");

        String selectedTimezone = "UTC-05:00";

        robot.interact(() -> {
            ComboBox<String> timezoneComboBox = robot.lookup("#timezoneComboBox").queryComboBox();
            timezoneComboBox.getSelectionModel().select(selectedTimezone);
        });
        robot.clickOn("#latitude").write("40.6446");
        robot.clickOn("#longitude").write("73.7858");

        robot.clickOn("#submitButton");
        DialogPane successDialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        assertNotNull(successDialogPane);
        assertEquals("This airport is already registered", successDialogPane.getHeaderText());
        robot.clickOn(".button:contains('ok')");

    }

    @Test
    public void registerAirplane (FxRobot robot){
        robot.clickOn("#registerAirplaneButton");
        robot.clickOn("#airplaneModelField").write("");
        //Boeing 737, Boeing 747, Airbus A330, Boeing 777
        String[] airplaneModels = {"Boeing 737", "Boeing 747", "Airbus A330", "Boeing 777"};
        Random random = new Random();
        String randomModel = airplaneModels[random.nextInt(airplaneModels.length)];
        robot.clickOn("#airplaneModelField");
        robot.write(randomModel);
        String randomLetters = "";
        for (int i = 0; i < 4; i++) {
            char c = (char) (random.nextInt(26) + 'A');
            randomLetters += c;
        }
        String registrationNumber = "PH" + randomLetters;
        robot.clickOn("#airplaneRegistrationNumber").write(registrationNumber);
        robot.clickOn("#fuelConsumptionField").write("2.8");
        int randomSeatNumber = random.nextInt(166) + 85;
        robot.clickOn("#totalSeatsField").write(String.valueOf(randomSeatNumber));
        int totalSeats = Integer.parseInt(robot.lookup("#totalSeatsField").queryTextInputControl().getText());
        int remainingSeats = totalSeats - 85;
        int minBusinessClassSeats = 8;
        int maxBusinessClassSeats = Math.min(remainingSeats, 20);
        int randomBusinessClassSeats = (int) (Math.random() * maxBusinessClassSeats) + minBusinessClassSeats;
        robot.clickOn("#businessClassSeatsField").write(Integer.toString(randomBusinessClassSeats));
        if (totalSeats>85){
            robot.clickOn("#extraLegroomSeatsField").write("12");
        }else robot.clickOn("#extraLegroomSeatsField").write("0");
        robot.clickOn("#luggageCapacityField").write("5500");
        robot.clickOn("#submitButton1");
        DialogPane successDialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        assertNotNull(successDialogPane);
        assertEquals("Airplane added successfully to the system", successDialogPane.getHeaderText());
        robot.clickOn(".button:contains('ok')");
    }

    @Test
    public void getALlFLightsOnTableTest(){
        //TODO
    }
}
