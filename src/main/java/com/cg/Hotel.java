package com.cg;

public class Hotel {
    String hotelName;
    int weekdayRate_Regular;
    int weekendRate_Regular;

    public Hotel(String hotelName, int weekdayRate_Regular, int weekendRate_Regular) {
        this.hotelName = hotelName;
        this.weekdayRate_Regular = weekdayRate_Regular;
        this.weekendRate_Regular = weekendRate_Regular;
    }

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getWeekdayRate_Regular() { return weekdayRate_Regular; }

    public void setWeekdayRate_Regular(int weekdayRate_Regular) { this.weekdayRate_Regular = weekdayRate_Regular; }

    public int getWeekendRate_Regular() { return weekendRate_Regular; }

    public void setWeekendRate_Regular(int weekendRate_Regular) { this.weekendRate_Regular = weekendRate_Regular; }
}
