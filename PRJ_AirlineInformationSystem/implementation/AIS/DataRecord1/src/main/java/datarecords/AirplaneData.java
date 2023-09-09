package datarecords;

import java.util.List;

public record AirplaneData(String airplaneModel, String airplaneRegistrationNumber, double fuelConsumptionPerKm, int numberOfBusinessClassSeats, int numberOfExtraLegroomSeats, int totalSeat, int capacity) {

    public AirplaneData {
        if (numberOfBusinessClassSeats + numberOfExtraLegroomSeats > totalSeat) {
            throw new IllegalArgumentException("The sum of business class seats and extra legroom seats cannot exceed the total number of seats.");
        }
    }

    @Override
    public String airplaneModel() {
        return airplaneModel;
    }

    @Override
    public String airplaneRegistrationNumber() {
        return airplaneRegistrationNumber;
    }

    @Override
    public double fuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    @Override
    public int numberOfBusinessClassSeats() {
        return numberOfBusinessClassSeats;
    }

    @Override
    public int numberOfExtraLegroomSeats() {
        return numberOfExtraLegroomSeats;
    }

    @Override
    public int totalSeat() {
        return totalSeat;
    }


}


