package businessLogic;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

public interface FlightService {

    public List<AirportData> getAllAirports();

    public void registerAirport(AirportData airportData);

    public void registerAirplane(AirplaneData airplaneData);

    public List<AirplaneData> getAllAirplanes();

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2);

    public LocalTime arrivalTimeCalculator(double distance, LocalTime departureTime, AirportData departureAirport, AirportData arrivalAirport);

    public void registerFlight(FlightData flightData);

    public boolean gateAvailability(AirportData arrivalAirport, LocalDate arrivalDate, LocalTime arrivalTime, int gateNumber);

    List<FlightData> getAllFlights();
}