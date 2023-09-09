package persistence;

public interface PersistenceFactory {

    //static method are useful especially if they are providing utility implementation.


    //This method provides a way to create an instance of the FlightStorageService interface using the FligthStorageServiceImpl implementation,
    // and it does not require any state or behavior specific to an instance of the implementing class.
    public static FlightStorageService createFlightStorageService (){
        return new FlightStorageServiceImpl();

    };

    static BookingStorageService createBookingStorageService() {
        return new BookingStorageServiceImpl();
    }


}
