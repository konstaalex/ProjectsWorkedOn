package businessLogic;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;
import persistence.FlightStorageService;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


public class FlightServiceImpl implements FlightService {
    private final FlightStorageService flightStorageService;


// this class is related to the database


    public FlightServiceImpl(FlightStorageService flightStorageService) {
        this.flightStorageService = flightStorageService;
    }



    public List<AirportData> getAllAirports (){
        return flightStorageService.getAllAirports();
    }

    @Override
    public List<AirplaneData> getAllAirplanes() {
        return flightStorageService.getAllAirplanes();
    }

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; //convert to km
    }

    @Override
    public LocalTime arrivalTimeCalculator(double distance, LocalTime departureTime, AirportData departureAirport, AirportData arrivalAirport) {
        //TODO fixing the timezones in the code.

        Duration rawDuration = Duration.ofMinutes(Math.round(distance / 830.0 * 60));
        // Calculate the flight duration without timezone difference

        // Combine the departure time with today's date
        ZonedDateTime departureZdt = ZonedDateTime.now(departureAirport.timezone()).with(departureTime);

        // Calculate the arrival time in the arrival airport's timezone
        ZonedDateTime arrivalZdt = departureZdt.plus(rawDuration).withZoneSameInstant(arrivalAirport.timezone());

        // Extract the LocalTime part from the ZonedDateTime
        LocalTime arrivalTime = arrivalZdt.toLocalTime();

        return arrivalTime;
    }

    @Override
    public void registerFlight(FlightData flightData) {
        flightStorageService.saveFlight(flightData);
    }

    public boolean gateAvailability (AirportData arrivalAirport, LocalDate arrivalDate, LocalTime arrivalTime, int gateNumber){
         return flightStorageService.isGateAvailable(arrivalAirport,arrivalDate,arrivalTime,gateNumber);
    }


    public void registerAirport(AirportData airportData){
        flightStorageService.addAirports(airportData);
    }

    public List<Integer> gateNumbers (AirportData airport){
        List<Integer> gateNumbers = new ArrayList<>();
        for (int i = 1; i <= airport.gates(); i++) {
            gateNumbers.add(i);
        }
        return gateNumbers;
    }

    public Flight findFlightById(String flightNumber){
        return null;
    }


    public void registerAirplane(AirplaneData airplaneData) {
        flightStorageService.addAirplane(airplaneData);

    }

    //validation of input
    public boolean isValidTime(int hour, int minute) {
        try {
            LocalTime time = LocalTime.of(hour, minute);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public boolean isAirplaneScheduled(AirplaneData airplane, LocalDate departureDate, LocalTime departureTime, AirportData selectedDepartureAirport) {
        // Retrieve all flights for the given airplane and departure date
        List<FlightData> flights = flightStorageService.getFlightsByRegistrationNumberAndDepartureDate(airplane.airplaneRegistrationNumber(), departureDate);

        // Iterate through all flights and check if the airplane is scheduled
        for (FlightData flight : flights) {
            LocalTime flightDepartureTime = flight.departureTime();
            AirportData flightDepartureAirport = flight.departureName();
            // Check if the departure time and airport match
            if (flightDepartureTime.equals(departureTime) && flightDepartureAirport.equals(selectedDepartureAirport)) {
                return true;
            }
        }
        return false;

    }

    /**
     * @return a list of FlightData from the FlightStorageService
     */
    public List<FlightData> getAllFlights(){
        return flightStorageService.getAllFLights();
    }



    public AirplaneData getAirplaneDataByRegistrationNumber(String fLightNumber){

        return flightStorageService.getAirplaneByRegistrationNumber(fLightNumber);

    }

}
