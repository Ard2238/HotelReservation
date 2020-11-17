package com.cg;

public class Hotel {
    private String hotelName;
    private int weekdayRate_Regular;
    private int weekendRate_Regular;
    private int ratings;

    public Hotel(String hotelName, int weekdayRate_Regular, int weekendRate_Regular, int ratings) {
        this.hotelName = hotelName;
        this.weekdayRate_Regular = weekdayRate_Regular;
        this.weekendRate_Regular = weekendRate_Regular;
        this.ratings =ratings;
    }

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getWeekdayRate_Regular() { return weekdayRate_Regular; }

    public void setWeekdayRate_Regular(int weekdayRate_Regular) { this.weekdayRate_Regular = weekdayRate_Regular; }

    public int getWeekendRate_Regular() { return weekendRate_Regular; }

    public void setWeekendRate_Regular(int weekendRate_Regular) { this.weekendRate_Regular = weekendRate_Regular; }

    public int getRatings() { return ratings; }

    public void setRatings(int ratings) { this.ratings = ratings; }
}
