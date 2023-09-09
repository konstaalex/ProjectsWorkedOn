package businessLogic;

import datarecords.FlightData;
import persistence.FlightStorageService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AirportManager {
    private final FlightStorageService flightStorageService;

    public AirportManager(FlightStorageService flightStorageService) {
        this.flightStorageService = flightStorageService;
    }

  //public void registerAirport
}
