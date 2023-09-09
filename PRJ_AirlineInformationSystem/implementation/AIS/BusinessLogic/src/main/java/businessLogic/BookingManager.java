package businessLogic;

import datarecords.BookingData;
import datarecords.PassengerData;
import datarecords.SeatData;

import java.sql.SQLException;
import java.time.LocalDate;

public interface BookingManager {


    /**
     * @param bookingData
     *
     *
     */
    public void addBooking(BookingData bookingData)throws SQLException ;


    /**
     * @param seatData
     * @param passengerData
     * @throws SQLException
     */
    public  void addPassengersAndSeat( SeatData seatData, PassengerData passengerData) throws SQLException;


    /**
     * @param airplaneRegistrationNumber
     * @param numberOfPassengers
     * @return
     */
    boolean isSeatAvailable(String airplaneRegistrationNumber, int numberOfPassengers);

    /**
     * @param nrOfTotalSeats
     * @param airplaneRegistrationNumber
     * @return
     */
    int generateSeatNumber(int nrOfTotalSeats, String airplaneRegistrationNumber );


    /**
     * @param generatedSeatNumber
     * @param airplaneRegistrationNumber
     * @return
     */
   boolean isSeatNrAvailable(int generatedSeatNumber, String airplaneRegistrationNumber);



    /**
     * @param airplaneRegistrationNumber
     * @return
     */
    int getNrOfTotalSeatsForSelectedFlight(String airplaneRegistrationNumber);

    /**
     * @param flightNumber
     * @param departureDate
     * @return
     */
    boolean   isBookingExists(String flightNumber, LocalDate departureDate);

    //int calculateBookingPrice();

    /**
     * @param firstName
     * @param lastName
     * @param passportNumber
     * @return
     */
    public boolean isBookingExistsForPassenger(String firstName, String lastName, String passportNumber);


    public int calculatePrice(boolean foodOption,boolean legroomOption,boolean luggageOption, int nrOfPass);
}
