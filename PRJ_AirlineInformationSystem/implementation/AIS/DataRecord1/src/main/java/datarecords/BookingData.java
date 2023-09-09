package datarecords;

public class BookingData {

    private String flightNumber;


    private int nrOfPassengers;


    public BookingData( String flightNumber, int nrOfPassengers) {

        this.flightNumber = flightNumber;
        this.nrOfPassengers = nrOfPassengers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }




    public int getNumberOfPassengers() {
        return this.nrOfPassengers;
    }


}
