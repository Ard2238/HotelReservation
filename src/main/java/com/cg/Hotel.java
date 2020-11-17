package com.cg;

public class Hotel {
    private String hotelName;
    private int weekdayRate_Regular;
    private int weekendRate_Regular;
    private int weekdayRate_Reward;
    private int weekendRate_Reward;
    private int ratings;

    public Hotel(String hotelName, int weekdayRate_Regular, int weekendRate_Regular, int weekdayRate_Reward, int weekendRate_Reward, int ratings) {
        this.hotelName = hotelName;
        this.weekdayRate_Regular = weekdayRate_Regular;
        this.weekendRate_Regular = weekendRate_Regular;
        this.weekdayRate_Reward = weekdayRate_Reward;
        this.weekendRate_Reward = weekendRate_Reward;
        this.ratings =ratings;
    }

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getWeekdayRate_Regular() { return weekdayRate_Regular; }

    public void setWeekdayRate_Regular(int weekdayRate_Regular) { this.weekdayRate_Regular = weekdayRate_Regular; }

    public int getWeekendRate_Regular() { return weekendRate_Regular; }

    public void setWeekendRate_Regular(int weekendRate_Regular) { this.weekendRate_Regular = weekendRate_Regular; }

    public int getRatings() { return ratings; }

    public int getWeekdayRate_Reward() { return weekdayRate_Reward; }

    public void setWeekdayRate_Reward(int weekdayRate_Reward) { this.weekdayRate_Reward = weekdayRate_Reward; }

    public int getWeekendRate_Reward() {
        return weekendRate_Reward;
    }

    public void setWeekendRate_Reward(int weekendRate_Reward) {
        this.weekendRate_Reward = weekendRate_Reward;
    }

    public void setRatings(int ratings) { this.ratings = ratings; }
}
