package persistence;

import datarecords.BookingData;
import datarecords.PassengerData;
import datarecords.SeatData;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


// interface  that describes all services offered by the BookingStorageService
public interface BookingStorageService {


    /**
     *  method for adding/saving a booking into the database
     */
    public void addBooking(BookingData bookingData) throws SQLException;


    public void addPassengerAndSeat( SeatData seatData, PassengerData passengerData) throws SQLException;
    /**
     * @return BookingData object
     *  it gets the booking data from the database
     */
    public BookingData getBooking(int bookingId) throws SQLException;

    /**
     * @return last booking id
     * @throws SQLException
     */
    public int getLastBookingID()throws SQLException;
    /**
     * @return list of  all bookings from the database
     */
    public List<BookingData> getAllBookings();

    /**
     * @return true or false depending on the number of available seats
     */
    public boolean isSeatAvailable(String airplaneRegistrationNumber,int numberOfPassengers);


    /**
     * @param generatedSeatNumber
     * @param airplaneRegistrationNumber
     * @return true if @param generatedSeatNumber is not find in the database
     */
    public boolean isSeatNrAvailable(int generatedSeatNumber, String airplaneRegistrationNumber);


    /**
     * @param airplaneRegistrationNumber
     * @return
     */
    int getNrOfTotalSeatsForSelectedFlight(String airplaneRegistrationNumber);


    /**
     * @param flightNumber
     * @param departureDate
     * @return true or false if the booking is or not in the database
     */
    boolean isBookingExists(String flightNumber, LocalDate departureDate);


    boolean isBookingExistsForPassenger(String firstName, String lastName, String passportNumber);
}
