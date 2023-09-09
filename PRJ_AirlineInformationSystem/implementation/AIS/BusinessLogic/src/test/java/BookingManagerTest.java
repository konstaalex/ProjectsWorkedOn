import businessLogic.BookingManager;
import businessLogic.BookingManagerImpl;
import businessLogic.BusinessLogicFactory;
import businessLogic.BusinessLogicFactoryImpl;
import datarecords.BookingData;
import datarecords.PassengerData;
import datarecords.SeatData;
import org.junit.jupiter.api.Test;
import persistence.BookingStorageService;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class BookingManagerTest {


    BookingManagerImpl bookingManager = BusinessLogicFactoryImpl.createBookingManager();

    @Test
    public void testConstructor() {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);

        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);


        assertThat(bookingManager).isNotNull();
        assertThat(bookingManager.getBookingStorageService()).isEqualTo(bookingStorageService);
    }


    @Test
    void isSeatAvailableTest(){
        //todo
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        String airplaneRegistrationNumber = "ABC123";
        int numberOfPassengers = 5;
        boolean expectedResult = true;

        // Configure the mock to return the expected result
        when(bookingStorageService.isSeatAvailable(airplaneRegistrationNumber, numberOfPassengers))
                .thenReturn(expectedResult);

        // Call the method under test
        boolean actualResult = bookingManager.isSeatAvailable(airplaneRegistrationNumber, numberOfPassengers);

        // Verify the mock interaction and assert the result
        verify(bookingStorageService).isSeatAvailable(airplaneRegistrationNumber, numberOfPassengers);
        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void testAddBooking() throws SQLException {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        BookingData bookingData = new BookingData("KL1111",3);

        // Call the method under test
        bookingManager.addBooking(bookingData);

        // Verify the mock interaction
        verify(bookingStorageService).addBooking(bookingData);
    }

    @Test
    void testAddBookingOnePassenger() throws SQLException {

        BookingManagerImpl bookingManager = BusinessLogicFactoryImpl.createBookingManager();
        BookingData bookingData = new BookingData("KL1111",1);
        // Call the method under test
        bookingManager.addBooking(bookingData);

        int bookingID = bookingManager.getLastBookingId();
        // Assert that the booking was added
        BookingData addedBooking = bookingManager.getBooking(bookingID);
        assertThat(addedBooking.getFlightNumber()).isEqualTo(bookingData.getFlightNumber());
        assertThat(addedBooking.getNumberOfPassengers()).isEqualTo(bookingData.getNumberOfPassengers());

    }

//    @Test
//    public void testAddOnePassengersAndSeatNoOptionsSelected() throws SQLException {
//
//        BookingManagerImpl bookingManager = BusinessLogicFactoryImpl.createBookingManager();
//        SeatData seatData = new SeatData(53,false,false,false,"123");
//        PassengerData passengerData = new PassengerData("alex","constantinescu","1234567");
//
//        bookingManager.addPassengersAndSeat(seatData, passengerData);
//        int bookingID = bookingManager.getLastBookingId();
//
//
//        // Assert that the booking was added
//        BookingData addedBooking = bookingManager.getBooking(bookingID);
//        
//        assertThat(addedBooking.getSeatData().getSeatNumber()).isEqualTo(seatData.getSeatNumber());
//        assertThat(addedBooking.getPassengerData().getFirstName()).isEqualTo(passengerData.getFirstName());
//        assertThat(addedBooking.getPassengerData().getLastName()).isEqualTo(passengerData.getLastName());
//        assertThat(addedBooking.getPassengerData().getPassportNumber()).isEqualTo(passengerData.getPassportNumber());
//    }

    @Test
    public void testAddPassengersAndSeat() throws SQLException {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        SeatData seatData = new SeatData(53,true,true,true,"123");
        PassengerData passengerData = new PassengerData("alexandru","mortiimatii","9000");

        // Call the method under test
        bookingManager.addPassengersAndSeat(seatData, passengerData);

        // Verify the mock interaction
        verify(bookingStorageService).addPassengerAndSeat(seatData, passengerData);
    }

    @Test
   void generateSeatNumberTest(){
        //todo
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        int nrOfTotalSeats = 100; // Example value
        String airplaneRegistrationNumber = "ABC123"; // Example value

        // Mock the behavior of isSeatNrAvailable
        when(bookingStorageService.isSeatNrAvailable(anyInt(), anyString())).thenReturn(true);

        // Call the method under test
        int generatedSeatNumber = bookingManager.generateSeatNumber(nrOfTotalSeats, airplaneRegistrationNumber);

        // Assert that the generated seat number is within the valid range
        assertThat(generatedSeatNumber).isBetween(1, nrOfTotalSeats);

        // Verify the mock interaction
        verify(bookingStorageService, atLeastOnce()).isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber);
    }

    @Test
    public void testIsSeatNrAvailable_WhenAvailable() {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        int generatedSeatNumber = 1; // Example value
        String airplaneRegistrationNumber = "ABC123"; // Example value

        // Mock the behavior of bookingStorageService.isSeatNrAvailable to return true
        when(bookingStorageService.isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber)).thenReturn(true);

        // Call the method under test
        boolean isSeatAvailable = bookingManager.isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber);

        // Assert that the seat is available
        assertThat(isSeatAvailable).isTrue();

        // Verify the mock interaction
        verify(bookingStorageService, atLeastOnce()).isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber);
    }

    @Test
    public void testIsSeatNrAvailable_WhenNotAvailable() {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        int generatedSeatNumber = 1; // Example value
        String airplaneRegistrationNumber = "ABC123"; // Example value

        // Mock the behavior of bookingStorageService.isSeatNrAvailable to return false
        when(bookingStorageService.isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber)).thenReturn(false);

        // Call the method under test
        boolean isSeatAvailable = bookingManager.isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber);

        // Assert that the seat is not available
        assertThat(isSeatAvailable).isFalse();

        // Verify the mock interaction
        verify(bookingStorageService, atLeastOnce()).isSeatNrAvailable(generatedSeatNumber, airplaneRegistrationNumber);
    }

    @Test
    public void testGetNrOfTotalSeatsForSelectedFlight() {
        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        BookingManagerImpl bookingManager = new BookingManagerImpl(bookingStorageService);

        String airplaneRegistrationNumber = "ABC123"; // Example value
        int expectedNumberOfSeats = 100; // Example value

        // Mock the behavior of bookingStorageService.getNrOfTotalSeatsForSelectedFlight to return the expected number of seats
        when(bookingStorageService.getNrOfTotalSeatsForSelectedFlight(airplaneRegistrationNumber)).thenReturn(expectedNumberOfSeats);

        // Call the method under test
        int actualNumberOfSeats = bookingManager.getNrOfTotalSeatsForSelectedFlight(airplaneRegistrationNumber);

        // Assert that the actual number of seats matches the expected number of seats
        assertThat(actualNumberOfSeats).isEqualTo(expectedNumberOfSeats);

        // Verify the mock interaction
        verify(bookingStorageService, atLeastOnce()).getNrOfTotalSeatsForSelectedFlight(airplaneRegistrationNumber);
    }

    @Test
    public void testCalculatePrice() {
        // Arrange
        boolean foodOption = true;
        boolean legroomOption = true;
        boolean luggageOption = false;
        int nrOfPass = 1;
        int expectedPrice = 135; // 20 (food) + 15 (legroom) + 0 (no luggage) + 100 (1 pass )

        // Act
        int calculatedPrice = bookingManager.calculatePrice(foodOption, legroomOption, luggageOption, nrOfPass);

        // Assert
        assertThat(calculatedPrice).isEqualTo(expectedPrice);
    }


    @Test
    public void testIsBookingExistsForPassenger() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        String passportNumber = "ABC123";

        BookingStorageService bookingStorageService = mock(BookingStorageService.class);
        when(bookingStorageService.isBookingExistsForPassenger(firstName, lastName, passportNumber)).thenReturn(true);

        BookingManager bookingService = BusinessLogicFactoryImpl.createBookingManager(bookingStorageService);

        // Act
        boolean result = bookingService.isBookingExistsForPassenger(firstName, lastName, passportNumber);

        // Assert
        assertThat(result).isTrue();
        verify(bookingStorageService).isBookingExistsForPassenger(firstName, lastName, passportNumber);
    }

    }

