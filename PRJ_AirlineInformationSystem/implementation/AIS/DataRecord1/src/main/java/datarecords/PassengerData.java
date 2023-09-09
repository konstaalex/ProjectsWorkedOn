package datarecords;

public class PassengerData {


    private final String firstName;
    private final String lastName;
    private final String passportNumber;

    public PassengerData(String firstName, String lastName, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }



}
