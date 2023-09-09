package datarecords;

import java.time.LocalDateTime;

public record GateData(int gateNumber, LocalDateTime availableUntil, AirportData airport) {
    public GateData {

    }

    public boolean isAvailable(LocalDateTime departureDateTime) {
        return departureDateTime.isAfter(availableUntil);
    }

    public GateData setAvailableUntil(LocalDateTime newAvailableTime) {
        return new GateData(this.gateNumber, newAvailableTime, this.airport);
    }
}
