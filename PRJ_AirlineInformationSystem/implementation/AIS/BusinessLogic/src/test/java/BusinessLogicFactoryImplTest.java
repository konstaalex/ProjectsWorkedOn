import businessLogic.BookingManagerImpl;
import businessLogic.BusinessLogicFactoryImpl;
import businessLogic.FlightServiceImpl;
import org.junit.jupiter.api.Test;


import org.mockito.Mock;
import persistence.FlightStorageService;
import persistence.PersistenceFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BusinessLogicFactoryImplTest {



    @Mock
    private FlightStorageService flightStorageService;
    @Test
    public void testCreateFlightService() {

        FlightServiceImpl flightServiceTest = BusinessLogicFactoryImpl.createFlightService();



        FlightServiceImpl flightServiceTestInstance = new FlightServiceImpl(flightStorageService);


        // Assert that the flightService instance is not null
        assertThat(flightServiceTest).isNotNull();
        assertThat(flightServiceTest).isInstanceOf(flightServiceTestInstance.getClass());

    }

    @Test
    public void testCreateBookingManager() {
        BookingManagerImpl bookingManager = BusinessLogicFactoryImpl.createBookingManager();

        // Assert that the bookingManager instance is not null
        assertThat(bookingManager).isNotNull();


    }


}
