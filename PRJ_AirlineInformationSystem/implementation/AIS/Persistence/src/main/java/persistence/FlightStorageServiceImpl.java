package persistence;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


//package-private -  to ensure that the implementation details are hidden from the rest of application



class FlightStorageServiceImpl implements FlightStorageService {

    PersistenceAPIImpl persistenceAPI = new PersistenceAPIImpl();



    public void addAirports(AirportData airportData) {
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("INSERT INTO airports (name, gates, timezone, latitude, longitude) VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, airportData.name());
            statement.setInt(2, airportData.gates());
            statement.setString(3, airportData.timezone().getId());
            statement.setDouble(4, airportData.latitude());
            statement.setDouble(5, airportData.longitude());
            statement.executeUpdate();


            int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addAirplane(AirplaneData airplaneData) {
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("INSERT INTO airplanes (airplane_model, airplane_number_registration, fuel_consumption_per_km, number_of_total_seats, number_of_business_class_seats, number_of_extra_legroom_seats, capacity) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, airplaneData.airplaneModel());
            statement.setString(2, airplaneData.airplaneRegistrationNumber());
            statement.setDouble(3, airplaneData.fuelConsumptionPerKm());
            statement.setInt(4, airplaneData.totalSeat());
            statement.setInt(5, airplaneData.numberOfBusinessClassSeats());
            statement.setInt(6, airplaneData.numberOfExtraLegroomSeats());
            statement.setInt(7, airplaneData.capacity());
            int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<AirportData> getAllAirports() {
        List<AirportData> airports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM airports")) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                AirportData airportData = new AirportData(
                        rs.getString("name"),
                        rs.getInt("gates"),
                        ZoneId.of(rs.getString("timezone")),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"));
                airports.add(airportData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    public AirportData getAirportByName(String name) {
        AirportData airportData = null;
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM airports WHERE name = ?")) {

            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                airportData = new AirportData(
                        rs.getString("name"),
                        rs.getInt("gates"),
                        ZoneId.of(rs.getString("timezone")),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airportData;
    }

    public boolean isGateAvailable(AirportData arrivalAirport, LocalDate arrivalDate, LocalTime arrivalTime, int gateNumber) {
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM flights WHERE arrival_name = ? AND arrival_date = ? AND arrival_time = ? AND gate = ?")) {
            statement.setString(1, arrivalAirport.name());
            statement.setDate(2, Date.valueOf(arrivalDate));
            statement.setTime(3, Time.valueOf(arrivalTime));
            statement.setInt(4, gateNumber);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count == 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<AirplaneData> getAllAirplanes() {
        List<AirplaneData> airplanes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM airplanes")) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                AirplaneData airplaneData = new AirplaneData(
                        rs.getString("airplane_model"),
                        rs.getString("airplane_number_registration"),
                        rs.getDouble("fuel_consumption_per_km"),
                        rs.getInt("number_of_business_class_seats"),
                        rs.getInt("number_of_extra_legroom_seats"),
                        rs.getInt("number_of_total_seats"),
                        rs.getInt("capacity"));
                airplanes.add(airplaneData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplanes;
    }

    public AirplaneData getAirplaneByRegistrationNumber(String registrationNumber) {
        AirplaneData airplaneData = null;
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM airplanes WHERE airplane_number_registration = ?")) {

            statement.setString(1, registrationNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                airplaneData = new AirplaneData(
                        rs.getString("airplane_model"),
                        rs.getString("airplane_number_registration"),
                        rs.getDouble("fuel_consumption_per_km"),
                        rs.getInt("number_of_business_class_seats"),
                        rs.getInt("number_of_extra_legroom_seats"),
                        rs.getInt("number_of_total_seats"),
                        rs.getInt("capacity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplaneData;
    }

// todo create saveBooking method for saving bookngs into the db

    @Override
    public void saveFlight(FlightData flightData) {
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("INSERT INTO flights (flight_number, departure_name, arrival_name, departure_date, departure_time, arrival_date, arrival_time, airplane_registration_number, gate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, flightData.flightNumber());
            statement.setString(2, flightData.departureName().name());
            statement.setString(3, flightData.arrivalName().name());
            statement.setDate(4, Date.valueOf(flightData.departureDate()));

            // Set departure date and time parameters
            java.sql.Time sqlDepartureTime = java.sql.Time.valueOf(flightData.departureTime());
            statement.setTime(5, sqlDepartureTime);

            statement.setDate(6, Date.valueOf(flightData.arrivalDate()));

            // Set arrival date and time parameters
            java.sql.Time sqlArrivalTime = java.sql.Time.valueOf(flightData.arrivalTime());
            statement.setTime(7, sqlArrivalTime);

            statement.setString(8, flightData.airplaneRegistrationNumber().airplaneRegistrationNumber());
            statement.setInt(9, flightData.gate());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FlightData> getAllFLights() {
        List<FlightData> flights = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT flight_number, departure_name, arrival_name, departure_date, departure_time, arrival_date, arrival_time, airplane_registration_number, gate FROM flights")) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                AirportData airportDataDeparture = getAirportByName(rs.getString("departure_name"));
                AirportData airportDataArrival = getAirportByName(rs.getString("arrival_name"));
                AirplaneData airplaneData = getAirplaneByRegistrationNumber(rs.getString("airplane_registration_number"));


                FlightData flightData = new FlightData(
                        rs.getString("flight_number"),
                        airportDataDeparture,
                        airportDataArrival,
                        rs.getDate("departure_date").toLocalDate(),
                        rs.getTime("departure_time").toLocalTime(),
                        rs.getDate("arrival_date").toLocalDate(),
                        rs.getTime("arrival_time").toLocalTime(),
                        airplaneData,
                        rs.getInt("gate"));
                flights.add(flightData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public List<FlightData> getFlightsByRegistrationNumberAndDepartureDate(String registrationNumber, LocalDate departureDate) {
        List<FlightData> flights = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword());
             PreparedStatement statement = connection.prepareStatement("SELECT flight_number, departure_name, arrival_name, departure_date, departure_time, arrival_date, arrival_time, airplane_registration_number, gate FROM flights WHERE airplane_registration_number = ? AND departure_date = ?")) {

            statement.setString(1, registrationNumber);
            statement.setDate(2, java.sql.Date.valueOf(departureDate));

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                AirportData airportDataDeparture = getAirportByName(rs.getString("departure_name"));
                AirportData airportDataArrival = getAirportByName(rs.getString("arrival_name"));
                AirplaneData airplaneData = getAirplaneByRegistrationNumber(rs.getString("airplane_registration_number"));

                FlightData flightData = new FlightData(
                        rs.getString("flight_number"),
                        airportDataDeparture,
                        airportDataArrival,
                        rs.getDate("departure_date").toLocalDate(),
                        rs.getTime("departure_time").toLocalTime(),
                        rs.getDate("arrival_date").toLocalDate(),
                        rs.getTime("arrival_time").toLocalTime(),
                        airplaneData,
                        rs.getInt("gate"));
                flights.add(flightData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
}

