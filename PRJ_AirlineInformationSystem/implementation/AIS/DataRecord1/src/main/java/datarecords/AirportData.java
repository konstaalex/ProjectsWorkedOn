package datarecords;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public record AirportData(String name, int gates, ZoneId timezone, double latitude, double longitude) {


    @Override
    public String name() {
        return name;
    }

    @Override
    public int gates() {
        return gates;
    }

    @Override
    public ZoneId timezone() {
        return timezone;
    }

    @Override
    public double latitude() {
        return latitude;
    }

    @Override
    public double longitude() {
        return longitude;
    }



}
