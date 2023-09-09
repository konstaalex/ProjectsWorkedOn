import businessLogic.FlightService;
import businessLogic.FlightServiceImpl;
import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import persistence.FlightStorageService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class FlightManagerTest {


    @InjectMocks
    private FlightServiceImpl flightService;

    @Mock
    private FlightStorageService flightStorageService;



    //TODO business logic test
    @Test
    void testCalculateDistance() {
        FlightService businessLogic = new FlightServiceImpl(flightStorageService);
        // Test data: Coordinates for two airports
        double lat1 = 51.4501; // Eindhoven Airport latitude
        double lon1 = 5.3745; // Eindhoven Airport longitude
        double lat2 = 54.6381; // Vilnius Airport latitude
        double lon2 = 25.2878; // Vilnius Airport longitude
        double expected = 1372.0;
        double actual = businessLogic.calculateDistance(lat1, lon1, lat2, lon2);
        double delta = 1.0; // Maximum accepted difference between expected and actual
        assertEquals(expected, actual, delta, "The calculated distance is incorrect");
    }

    @Test
    void getAllAirportTest (){
        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);

        List<AirportData> expectedAirports = Arrays.asList(
                new AirportData("AMS", 2, ZoneId.of("UTC+01:00"), 52.3105, 4.7683),
                new AirportData("VNO", 1, ZoneId.of("UTC+02:00"), 54.638, 25.2866)
        );

        Mockito.when(mockFlightStorageService.getAllAirports()).thenReturn(expectedAirports);

        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);
        List<AirportData> actualAirports = flightManager.getAllAirports();
        assertEquals(expectedAirports, actualAirports);
    }

    //test

    @Test
    void getAllAirplanesTest(){
        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);
        List<AirplaneData> expectedAirplanes = Arrays.asList(
                new AirplaneData("Boeing 747","PHRDBL",2.8,20,12,188,5500),
                new AirplaneData("Boeing 777", "PHAAAA",2.8,10,12,200,5500)
        );
        Mockito.when(mockFlightStorageService.getAllAirplanes()).thenReturn(expectedAirplanes);
        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);

        List<AirplaneData> actualAirplanes = flightManager.getAllAirplanes();
        assertEquals(expectedAirplanes,actualAirplanes);
    }

    @Test
    void registerFlightTest (){
        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);
        AirportData departureAirport = new AirportData("AMS", 10, ZoneId.of("UTC+02:00"), 52.3090694, 4.7633857);
        AirportData arrivalAirport = new AirportData("VNO", 6, ZoneId.of("UTC+02:00"), 54.6438011, 25.2799093);
        AirplaneData airplane = new AirplaneData("PHAAA", "Boeing 737", 2.8, 12,12,120,5500);
        LocalDate departureDate = LocalDate.of(2023, 5, 24);
        LocalTime departureTime = LocalTime.of(13, 45);
        LocalDate arrivalDate = LocalDate.of(2023, 5, 24);
        LocalTime arrivalTime = LocalTime.of(15, 45);
        FlightData flightData = new FlightData("KL5690", departureAirport, arrivalAirport, departureDate, departureTime, arrivalDate, arrivalTime, airplane, 1);
        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);
        // Call the method under test with the mock data
        flightManager.registerFlight(flightData);
        // Verify that the FlightStorageService.saveFlight() method was called with the correct data
        Mockito.verify(mockFlightStorageService, Mockito.times(1)).saveFlight(flightData);
    }

    @Test
    void checkGateAvailabilityTest (){
        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);

        // Define test inputs
        AirportData arrivalAirport = new AirportData("VNO",2,ZoneId.of("UTC+02:00"),54.638,25.2866);
        LocalDate arrivalDate = LocalDate.of(2023, 5, 1);
        LocalTime arrivalTime = LocalTime.of(10, 30);
        int gateNumber = 2;
        boolean expectedResult = true;
        when(mockFlightStorageService.isGateAvailable(arrivalAirport, arrivalDate, arrivalTime, gateNumber)).thenReturn(expectedResult);
        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);

        boolean actualResult = flightManager.gateAvailability(arrivalAirport, arrivalDate, arrivalTime, gateNumber);
        assertEquals(expectedResult, actualResult);

    }


    /**
     * tests the getAllFlights method from FlightServiceImpl
     */
    @Test
    void getAllFlightsTest (){
        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);
        //first flight
        AirportData departureAirport = new AirportData("AMS", 10, ZoneId.of("UTC+02:00"), 52.3090694, 4.7633857);
        AirportData arrivalAirport = new AirportData("VNO", 6, ZoneId.of("UTC+02:00"), 54.6438011, 25.2799093);
        AirplaneData airplane = new AirplaneData("PHAAA", "Boeing 737", 2.8, 12,12,120,5500);
        LocalDate departureDate = LocalDate.of(2023, 5, 24);
        LocalTime departureTime = LocalTime.of(13, 45);
        LocalDate arrivalDate = LocalDate.of(2023, 5, 24);
        LocalTime arrivalTime = LocalTime.of(15, 45);
        //second flight
        AirportData departureAirport2 = new AirportData("BUC", 10, ZoneId.of("UTC+03:00"), 44.4268, 26.1025);
        AirportData arrivalAirport2 = new AirportData("EIN", 6, ZoneId.of("UTC+02:00"), 51.4231, 5.4623);
        AirplaneData airplane2 = new AirplaneData("PHAAAB", "Boeing 736", 2.8, 12,12,120,5500);
        LocalDate departureDate2 = LocalDate.of(2023, 6, 24);
        LocalTime departureTime2 = LocalTime.of(13, 45);
        LocalDate arrivalDate2 = LocalDate.of(2023, 6, 24);
        LocalTime arrivalTime2 = LocalTime.of(15, 45);


        List<FlightData> expectedFlights = Arrays.asList(
                new FlightData("KL5690", departureAirport, arrivalAirport, departureDate, departureTime, arrivalDate, arrivalTime, airplane, 1),
                new FlightData("KL5691", departureAirport2,arrivalAirport2,departureDate2,departureTime2,arrivalDate2,arrivalTime2,airplane2,2)
        );

        Mockito.when(mockFlightStorageService.getAllFLights()).thenReturn(expectedFlights);
        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);

        List<FlightData> actualFlights = flightManager.getAllFlights();

        assertEquals(expectedFlights,actualFlights);

    }

}
//
//    List<AirplaneData> expectedAirplanes = Arrays.asList(
//            new AirplaneData("Boeing 747","PHRDBL",2.8,20,12,188,5500),
//            new AirplaneData("Boeing 777", "PHAAAA",2.8,10,12,200,5500)
//    );
//        Mockito.when(mockFlightStorageService.getAllAirplanes()).thenReturn(expectedAirplanes);
//                FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);
//                List<AirplaneData> actualAirplanes = flightManager.getAllAirplanes();
//        assertEquals(expectedAirplanes,actualAirplanes);
//
//        FlightStorageService mockFlightStorageService = Mockito.mock(FlightStorageService.class);
//        List<AirplaneData> expectedAirplanes = Arrays.asList(
//        new AirplaneData("Boeing 747","PHRDBL",2.8,20,12,188,5500),
//        new AirplaneData("Boeing 777", "PHAAAA",2.8,10,12,200,5500)
//        );
//        Mockito.when(mockFlightStorageService.getAllAirplanes()).thenReturn(expectedAirplanes);
//        FlightService flightManager = new FlightServiceImpl(mockFlightStorageService);
//        List<AirplaneData> actualAirplanes = flightManager.getAllAirplanes();
//        assertEquals(expectedAirplanes,actualAirplanes);