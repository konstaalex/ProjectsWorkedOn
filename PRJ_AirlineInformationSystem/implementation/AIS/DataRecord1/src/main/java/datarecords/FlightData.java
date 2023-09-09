package datarecords;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public record FlightData(String flightNumber, AirportData departureName, AirportData arrivalName, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, AirplaneData airplaneRegistrationNumber, int gate) {



    @Override
    public String flightNumber() {
        return flightNumber;
    }

    public String departureAirportName(){
        return departureName.name();
    }

    public String arrivalAirportName(){
        return arrivalName.name();
    }

    @Override
    public AirportData departureName() {
        return departureName;
    }

    @Override
    public AirportData arrivalName() {
        return arrivalName;
    }

    @Override
    public LocalDate departureDate() {
        return departureDate;
    }


    @Override
    public LocalTime departureTime() {
        return departureTime;
    }

    @Override
    public AirplaneData airplaneRegistrationNumber() {
        return airplaneRegistrationNumber;
    }

    public String getAirplaneRegistrationNumber(){
        return airplaneRegistrationNumber.airplaneRegistrationNumber();
    }
    @Override
    public int gate() {
        return gate;
    }

    @Override
    public LocalDate arrivalDate() {
        return arrivalDate;
    }

    @Override
    public LocalTime arrivalTime() {
        return arrivalTime;
    }



}
