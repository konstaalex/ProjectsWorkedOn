package gui.Utility;

import businessLogic.BookingManagerImpl;
import datarecords.FlightData;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlightDataSaver {

    private SimpleStringProperty flightNumbers;

    private ObjectProperty<LocalTime> departure;
    private ObjectProperty<LocalTime> arrival;
    private ObjectProperty<LocalDate> departureDate;
    private ObjectProperty<LocalDate> arrivalDate;
    private SimpleIntegerProperty totalSeats;

    private String departureAirport;

    private String arrivalAirport;

    private String airplaneNumberRegistration;


    private BookingManagerImpl booking;




    public FlightDataSaver(FlightData flight) {

        this.flightNumbers = new SimpleStringProperty(flight.flightNumber());
        this.departure = new SimpleObjectProperty(flight.departureTime());
        this.arrival = new SimpleObjectProperty<>(flight.arrivalTime());
        this.departureDate = new SimpleObjectProperty<>(flight.departureDate());
        this.arrivalDate = new SimpleObjectProperty<>(flight.arrivalDate());
        this.departureAirport = flight.departureAirportName();
        this.arrivalAirport = flight.arrivalAirportName();
        this.airplaneNumberRegistration = flight.getAirplaneRegistrationNumber();
       // this.totalSeats = new SimpleIntegerProperty();
//        //id airplane

      //  this.booking = new BookingManagerImpl();

    }

    public String getAirplaneNumberRegistration() {
        return airplaneNumberRegistration;
    }

    public String getFlightNumbers() {
        return flightNumbers.get();
    }

    public SimpleStringProperty flightNumbersProperty() {
        return flightNumbers;
    }

    public void setFlightNumbers(String flightNumbers) {
        this.flightNumbers.set(flightNumbers);
    }

    public LocalTime getDeparture() {
        return departure.get();
    }

    public ObjectProperty<LocalTime> departureProperty() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure.set(departure);
    }

    public LocalTime getArrival() {return arrival.get();}

    public ObjectProperty<LocalTime> arrivalProperty() {
        return arrival;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival.set(arrival);
    }

    public LocalDate getDepartureDate() {
        return departureDate.get();
    }

    public ObjectProperty<LocalDate> departureDateProperty() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate.set(departureDate);
    }

    public LocalDate getArrivalDate() {
        return arrivalDate.get();
    }

    public ObjectProperty<LocalDate> arrivalDateProperty() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate.set(arrivalDate);
    }

    public int getTotalSeats() {
        return totalSeats.get();
    }

    public SimpleIntegerProperty totalSeatsProperty() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats.set(totalSeats);
    }

    public List<FlightData> getAllFlightData(){
        return null;
    }


    public String getDepartureAirportName() {

        return departureAirport;

    }

    public String getArrivalAirportName() {

        return arrivalAirport;
    }


}
