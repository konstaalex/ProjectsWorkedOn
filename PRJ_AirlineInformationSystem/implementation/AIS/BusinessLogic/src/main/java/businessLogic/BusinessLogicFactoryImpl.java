package businessLogic;

import persistence.BookingStorageService;
import persistence.FlightStorageService;
import persistence.PersistenceFactory;

public class BusinessLogicFactoryImpl implements BusinessLogicFactory{



    /**
     * @return FlightServiceImpl object that contains a FLightStorageService
     */
    public static FlightServiceImpl createFlightService() {
        FlightStorageService flightStorageService = PersistenceFactory.createFlightStorageService();
        return new FlightServiceImpl(flightStorageService);

    }


    public static  BookingManagerImpl createBookingManager() {
        BookingStorageService bookingStorageService = PersistenceFactory.createBookingStorageService();
        return new BookingManagerImpl(bookingStorageService);
    }

    public static BookingManagerImpl createBookingManager(BookingStorageService bookingStorageService){

        return new BookingManagerImpl(bookingStorageService);

    }
}
