package persistence;

import datarecords.BookingData;
import datarecords.PassengerData;
import datarecords.SeatData;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookingStorageServiceImpl implements BookingStorageService{

    PersistenceAPIImpl persistenceAPI = new PersistenceAPIImpl();



    @Override
    public void addBooking(BookingData bookingData) throws SQLException {
        try (Connection conn = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())){
             conn.setAutoCommit(false); // Start a transaction

            try {
            // Insert into bookings table
            String insertBookingQuery = "INSERT INTO bookings (flight_number, number_of_passengers) VALUES (?, ?)";
            PreparedStatement bookingStatement = conn.prepareStatement(insertBookingQuery);
            bookingStatement.setString(1, bookingData.getFlightNumber());
            bookingStatement.setInt(2, bookingData.getNumberOfPassengers());
            bookingStatement.executeUpdate();
            bookingStatement.close();



            conn.commit(); // Commit the transaction
        } catch (SQLException ex) {
            conn.rollback(); // Rollback the transaction if an error occurs
            throw ex;
        }
    }
    }

    public int getLastBookingID()throws SQLException {
        try (Connection conn = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {
            conn.setAutoCommit(false); // Start a transaction

            try {


                // Retrieve the last generated booking ID
                int bookingId;
                String getLastBookingIdQuery = "SELECT id FROM bookings ORDER BY id DESC LIMIT 1";
                PreparedStatement getLastBookingIdStatement = conn.prepareStatement(getLastBookingIdQuery);
                ResultSet lastBookingIdResult = getLastBookingIdStatement.executeQuery();
                if (lastBookingIdResult.next()) {
                    bookingId = lastBookingIdResult.getInt("id");

                    getLastBookingIdStatement.close();
                    return bookingId;

                } else {
                    getLastBookingIdStatement.close();
                    throw new SQLException("Failed to retrieve the last generated booking ID.");
                }

            } catch (SQLException ex) {
                conn.rollback(); // Rollback the transaction if an error occurs
                throw ex;
            }

        }

    }
    @Override
    public void addPassengerAndSeat(SeatData seatData, PassengerData passengerData) throws SQLException {
        try (Connection conn = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())){
            conn.setAutoCommit(false); // Start a transaction

            try {


                // Retrieve the last generated booking ID
                int bookingId;
                String getLastBookingIdQuery = "SELECT id FROM bookings ORDER BY id DESC LIMIT 1";
                PreparedStatement getLastBookingIdStatement = conn.prepareStatement(getLastBookingIdQuery);
                ResultSet lastBookingIdResult = getLastBookingIdStatement.executeQuery();
                if (lastBookingIdResult.next()) {
                    bookingId = lastBookingIdResult.getInt("id");
                } else {
                    throw new SQLException("Failed to retrieve the last generated booking ID.");
                }
                getLastBookingIdStatement.close();


                // Get the generated booking ID
             //   int bookingId = 7;
//                try (PreparedStatement lastInsertIdStatement = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
//                    bookingId = lastInsertIdStatement.executeQuery().getInt(1);
//                }

                // Insert into passengers table
                String insertPassengerQuery = "INSERT INTO passengers (first_name, last_name, passport_number, booking_id) VALUES (?, ?, ?, ?)";
                PreparedStatement passengerStatement = conn.prepareStatement(insertPassengerQuery);
                passengerStatement.setString(1, passengerData.getFirstName());
                passengerStatement.setString(2, passengerData.getLastName());
                passengerStatement.setString(3, passengerData.getPassportNumber());
                passengerStatement.setInt(4, bookingId);
                passengerStatement.executeUpdate();
                passengerStatement.close();

                // Insert into seats table
                String insertSeatQuery = "INSERT INTO seats (seat_number, food_service, extra_legroom, extra_luggage, airplane_registration_number) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement seatStatement = conn.prepareStatement(insertSeatQuery);
                seatStatement.setInt(1, seatData.seatNumber());
                seatStatement.setBoolean(2, seatData.foodService());
                seatStatement.setBoolean(3, seatData.extraLegroom());
                seatStatement.setBoolean(4, seatData.extraLuggage());
                seatStatement.setString(5, seatData.getAirplaneRegistrationNumber());
                seatStatement.executeUpdate();
                seatStatement.close();

                conn.commit(); // Commit the transaction
            } catch (SQLException ex) {
                conn.rollback(); // Rollback the transaction if an error occurs
                throw ex;
            }
        }
    }


    @Override
    public BookingData getBooking(int bookingID) throws SQLException {
        String query = "SELECT * FROM bookings WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, bookingID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String flightNumber = resultSet.getString("flight_number");
                    int numberOfPassengers = resultSet.getInt("number_of_passengers");

                    return new BookingData(flightNumber, numberOfPassengers);
                }
            } catch (SQLException ex) {
                connection.rollback(); // Rollback the transaction if an error occurs
                throw ex;
            }

            return null; // Return null if no booking is found with the provided booking ID
        }

    }
    @Override
    public List<BookingData> getAllBookings() {
        return null;
    }

    @Override
    public boolean isSeatAvailable(String airplaneRegistrationNumber, int numberOfPassengers) {



        int totalSeats = 0;
        int occupiedSeats = 0;

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {

            // Get the total number of seats for the airplane
            PreparedStatement totalSeatsStatement = connection.prepareStatement("SELECT number_of_total_seats FROM airplanes WHERE airplane_number_registration = ?");
            totalSeatsStatement.setString(1, airplaneRegistrationNumber);
            ResultSet totalSeatsResult = totalSeatsStatement.executeQuery();
            if (totalSeatsResult.next()) {
                totalSeats = totalSeatsResult.getInt("number_of_total_seats");
            } else {
                // Airplane not found in the database
                return false;
            }

            // Get the count of occupied seats for the airplane
            PreparedStatement occupiedSeatsStatement = connection.prepareStatement("SELECT COUNT(*) AS occupied_seats FROM seats WHERE airplane_registration_number = ?");
            occupiedSeatsStatement.setString(1, airplaneRegistrationNumber);
            ResultSet occupiedSeatsResult = occupiedSeatsStatement.executeQuery();
            if (occupiedSeatsResult.next()) {
                occupiedSeats = occupiedSeatsResult.getInt("occupied_seats");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        int availableSeats = totalSeats - occupiedSeats;
        return availableSeats >= numberOfPassengers;







    }

    @Override
    public boolean isSeatNrAvailable(int generatedSeatNumber, String airplaneRegistrationNumber) {

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {
            String query = "SELECT COUNT(*) FROM seats WHERE seat_number = ? AND airplane_registration_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, generatedSeatNumber);
                statement.setString(2, airplaneRegistrationNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count == 0; // Seat number is available if count is 0
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while connecting to the database or executing the query:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNrOfTotalSeatsForSelectedFlight(String airplaneRegistrationNumber) {

        int nrOfTotalSeats = 0;
        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {

            String query = "SELECT number_of_total_seats FROM airplanes WHERE airplane_number_registration = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airplaneRegistrationNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        nrOfTotalSeats = resultSet.getInt("number_of_total_seats");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while connecting to the database or executing the query:");
            e.printStackTrace();
        }
        return nrOfTotalSeats;
    }


    @Override
    public boolean isBookingExists(String flightNumber, LocalDate departureDate) {
        String query = "SELECT COUNT(*) FROM bookings WHERE flight_number = ? AND departure_date = ?";

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, flightNumber);
            statement.setDate(2, Date.valueOf(departureDate));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if the count is greater than 0, indicating that the booking exists
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while connecting to the database or executing the query:");
            e.printStackTrace();
        }

        return false; // Return false if an error occurs or no booking is found
    }


    @Override
    public boolean isBookingExistsForPassenger(String firstName, String lastName, String passportNumber) {
        String query = "SELECT COUNT(*) FROM passengers WHERE first_name = ? AND last_name = ? AND passport_number = ?";

        try (Connection connection = DriverManager.getConnection(persistenceAPI.getConnectionUrl(), persistenceAPI.getUsername(), persistenceAPI.getPassword())) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, passportNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if the count is greater than 0, indicating that the booking exists for the passenger
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while connecting to the database or executing the query:");
            e.printStackTrace();
        }

        return false; // Return false if an error occurs or no booking is found for the passenger
    }


}



















