package businessLogic;

import persistence.FlightStorageService;

public interface BusinessLogicAPI {
// it is an interface that defines the API for the business logic layer of the application.

    FlightServiceImpl getFlightManager();
    BookingManagerImpl getBookingManager();







//    static BusinessLogicAPI getImplementation(FlightStorageService flightStorageService) {
//
//        return new BusinessLogicAPIImpl(flightStorageService);
//
//    }


}
