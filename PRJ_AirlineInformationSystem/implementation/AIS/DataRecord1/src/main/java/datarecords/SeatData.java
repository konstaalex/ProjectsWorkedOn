package datarecords;




public record SeatData(int seatNumber, boolean foodService,boolean extraLegroom,boolean extraLuggage,  String airplaneRegistrationNumber) {


    @Override
    public int seatNumber() {
        return seatNumber;
    }

    @Override
    public boolean foodService() {
        return foodService;
    }

    @Override
    public boolean extraLegroom() {
        return extraLegroom;
    }

    @Override
    public boolean extraLuggage() {
        return extraLuggage;
    }


    public String getAirplaneRegistrationNumber(){
        return airplaneRegistrationNumber;
    }
}
