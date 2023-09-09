package persistence;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface FlightStorageService {
    // * Interface that describes all services offered by the FlightStorageService.

    //AirportData add(AirportData airportData);



    public void addAirports(AirportData airportData);

    public void addAirplane (AirplaneData airplaneData);
    public List<AirportData> getAllAirports();

    public List<AirplaneData> getAllAirplanes();

    public boolean isGateAvailable(AirportData arrivalAirport, LocalDate arrivalDate, LocalTime arrivalTime, int gateNumber);


    public void saveFlight(FlightData flightData);

    List<FlightData> getAllFLights();

    public AirplaneData getAirplaneByRegistrationNumber(String registrationNumber);
    public List<FlightData> getFlightsByRegistrationNumberAndDepartureDate(String registrationNumber, LocalDate departureDate);
}
