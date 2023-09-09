package businessLogic;

import persistence.BookingStorageService;
import persistence.FlightStorageService;
import persistence.PersistenceFactory;

public class BusinessLogicAPIImpl implements BusinessLogicAPI{

    private FlightStorageService flightStorageService;

    private BookingStorageService bookingStorageService;




//    public BusinessLogicAPIImpl (FlightStorageService flightStorageService){
//      this.flightStorageService = PersistenceFactory.createFlightStorageService();
//
//    }

    public BusinessLogicAPIImpl() {

    }


    @Override
    public FlightServiceImpl getFlightManager() {
        //return new FlightManager(PersistenceAPI.getFlightStorageService());
        //database is mocked
        return new FlightServiceImpl(flightStorageService);
    }

    @Override
    public BookingManagerImpl getBookingManager() {
        return new BookingManagerImpl(bookingStorageService);
    }


}
