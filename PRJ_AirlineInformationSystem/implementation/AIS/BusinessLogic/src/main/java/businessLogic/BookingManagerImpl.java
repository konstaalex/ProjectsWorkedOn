package businessLogic;

import datarecords.AirplaneData;
import datarecords.BookingData;
import datarecords.PassengerData;
import datarecords.SeatData;
import persistence.BookingStorageService;
import persistence.FlightStorageService;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.Random;

public class BookingManagerImpl implements BookingManager {


        private final BookingStorageService bookingStorageService;



    public BookingManagerImpl(BookingStorageService bookingStorageService) {

        this.bookingStorageService = bookingStorageService;

    }

    public BookingStorageService getBookingStorageService(){
        return this.bookingStorageService;
    }

    public boolean isSeatAvailable(String airplaneRegistrationNumber, int numberOfPassengers){
                return this.bookingStorageService.isSeatAvailable( airplaneRegistrationNumber, numberOfPassengers);

    }

    @Override
    public void addBooking(BookingData bookingData) throws SQLException {

            bookingStorageService.addBooking(bookingData);

    }

    @Override
    public void addPassengersAndSeat(SeatData seatData, PassengerData passengerData) throws SQLException{

        bookingStorageService.addPassengerAndSeat(seatData,passengerData);
    }


    public int generateSeatNumber(int nrOfTotalSeats, String airplaneRegistrationNumber ){

        Random random = new Random();
        int minSeatNumber = 1;
        int maxSeatNumber = nrOfTotalSeats;

        int generatedSeatNumber =  random.nextInt(maxSeatNumber - minSeatNumber + 1) + minSeatNumber;

        boolean isSeatNrAvailable = isSeatNrAvailable(generatedSeatNumber,airplaneRegistrationNumber);

        while (isSeatNrAvailable == false){
            generatedSeatNumber = random.nextInt(maxSeatNumber - minSeatNumber + 1) + minSeatNumber;
            isSeatNrAvailable = isSeatNrAvailable(generatedSeatNumber,airplaneRegistrationNumber);
        }

        return generatedSeatNumber;
    }


    public boolean isSeatNrAvailable(int generatedSeatNumber, String airplaneRegistrationNumber) {

        return bookingStorageService.isSeatNrAvailable( generatedSeatNumber,  airplaneRegistrationNumber);

    }


    public int getNrOfTotalSeatsForSelectedFlight(String airplaneRegistrationNumber){

        return bookingStorageService.getNrOfTotalSeatsForSelectedFlight(airplaneRegistrationNumber);
    }

    @Override
    public boolean isBookingExists(String flightNumber, LocalDate departureDate) {
      return  bookingStorageService.isBookingExists(flightNumber,departureDate);
    }

    @Override
    public boolean isBookingExistsForPassenger(String firstName, String lastName, String passportNumber) {
        return bookingStorageService.isBookingExistsForPassenger(firstName,lastName,passportNumber);
    }

    @Override
    public int calculatePrice(boolean foodOption, boolean legroomOption, boolean luggageOption, int nrOfPass) {

        int totalPrice = 0;

        if (foodOption) {
            totalPrice += 20;
        }

        if (legroomOption) {
            totalPrice += 15;
        }

        if (luggageOption) {
            totalPrice += 50;
        }


            totalPrice+=100;



        return totalPrice;



    }

    public BookingData getBooking(int bookingID) throws SQLException {
        return bookingStorageService.getBooking(bookingID);
    }

    public int getLastBookingId()throws SQLException{

        return bookingStorageService.getLastBookingID();
    }

}
