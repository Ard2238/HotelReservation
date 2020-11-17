package com.cg;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
    private static final List<Hotel> hotelList = new ArrayList<Hotel>();
    private static final Map<String, Customer> customerHotelMap = new HashMap<>();

    public List<Hotel> getHotelList() { return hotelList; }
    public Map<String, Customer> getCustomerHotelMap() { return customerHotelMap; }

    Scanner input = new Scanner(System.in);

    public List<Hotel> addHotel(){
        System.out.println("Enter the Hotel's Name: ");
        String hotelName = input.nextLine();
        System.out.println("Enter the weekday rates for Regular customers: ");
        int weekday_rate_regular = input.nextInt(); input.nextLine();
        System.out.println("Enter the weekend rates for Regular customers: ");
        int weekend_rate_regular = input.nextInt(); input.nextLine();
        System.out.println("Enter the weekday rates for Reward customers: ");
        int weekday_rate_reward = input.nextInt(); input.nextLine();
        System.out.println("Enter the weekend rates for Reward customers: ");
        int weekend_rate_reward = input.nextInt(); input.nextLine();
        System.out.println("Enter the ratings for the hotel");
        int ratings = input.nextInt(); input.nextLine();

        Hotel hotel = new Hotel(hotelName, weekday_rate_regular, weekend_rate_regular, weekday_rate_reward, weekend_rate_reward, ratings);
        hotelList.add(hotel);
        return hotelList;
    }

    public Map<String, Customer> addCustomer(){
        System.out.println("Enter the Hotel you want to add the Customer to: " );
        String hotelName = input.nextLine();
        System.out.println("Enter the Customer's Name: ");
        String customerName = input.nextLine();
        System.out.println("Enter the Customer's Type: ");
        String customerType = input.nextLine();

        Customer customer = new Customer(customerName, customerType);
        customerHotelMap.put(hotelName, customer);
        return customerHotelMap;
    }

    public int calculateHotelPriceForGivenDates(Hotel hotel, String startDate, String endDate, String customerType) throws ParseException {
        int price = 0;

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date dateStart = sdf.parse(startDate);
        Date dateEnd = sdf.parse(endDate);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(dateStart);
        end.setTime(dateEnd);
        Date commence = start.getTime();
        while(start.before(end) || start.equals(end)) {
            if (customerType.equalsIgnoreCase("Regular")) {
                switch (sdf1.format(commence)) {
                    case "Monday":
                    case "Tuesday":
                    case "Wednesday":
                    case "Thursday":
                    case "Friday": {
                        price += hotel.getWeekdayRate_Regular();
                        break;
                    }
                    case "Saturday":
                    case "Sunday": {
                        price += hotel.getWeekendRate_Regular();
                        break;
                    }
                }
            }else if(customerType.equalsIgnoreCase("Reward")){
                switch (sdf1.format(commence)) {
                    case "Monday":
                    case "Tuesday":
                    case "Wednesday":
                    case "Thursday":
                    case "Friday": {
                        price += hotel.getWeekdayRate_Reward();
                        break;
                    }
                    case "Saturday":
                    case "Sunday": {
                        price += hotel.getWeekendRate_Reward();
                        break;
                    }
                }
            }else{
                System.out.println("Wrong Input.");
            }
            start.add(Calendar.DATE, 1);
            commence = start.getTime();
        }
        hotel.setTotalPrice(price);
        return price;
    }

    public long findCheapestHotel(String customerType, String startDate, String endDate) throws ParseException {
        long cheapestPrice = Long.MAX_VALUE;
        String hotelName = "";
        int bestRatings  = 0;

        boolean validate = validateInput(startDate, endDate, customerType);
        if (validate == false) {
            System.out.println("Invalid Entries");
            return 0;
        }else{
            for(Hotel hotel : hotelList){
                int price = calculateHotelPriceForGivenDates(hotel, startDate, endDate, customerType);
                int rate = hotel.getRatings();
                if(price <= cheapestPrice && rate > bestRatings){
                    cheapestPrice = price;
                    hotelName = hotel.getHotelName();
                    bestRatings = hotel.getRatings();
                }
            }
            System.out.println("Hotel: " + hotelName + " Rating: " + bestRatings + " Total Rates: " + cheapestPrice);
            return cheapestPrice;
        }
    }

    public void findBestRatedHotel(String customerType, String startDate, String endDate) throws ParseException {
        int ratings = 0;
        int rates = 0;
        String hotelName = "";
        for(Hotel hotel : hotelList) {
            int price = calculateHotelPriceForGivenDates(hotel, startDate, endDate, customerType);
            if(hotel.getRatings() > ratings){
                ratings = hotel.getRatings();
                rates = price;
                hotelName = hotel.getHotelName();
            }
        }
        System.out.println("Hotel: " + hotelName + " Total Rates: " + rates);
    }

    public boolean validateInput(String startDate, String endDate, String customerType) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateStart = sdf.parse(startDate);
        Date dateEnd = sdf.parse(endDate);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(dateStart);
        end.setTime(dateEnd);
        if(end.before(start) || (!customerType.equalsIgnoreCase("Regular") && !customerType.equalsIgnoreCase("Reward")))
            return false;
        return true;
    }

    public int findCheapestBestRatedHotel(String customerType, String startDate, String endDate) throws ParseException {
        for(Hotel hotel: hotelList){
            calculateHotelPriceForGivenDates(hotel, startDate, endDate, customerType);
        }
        Hotel hotel = hotelList.stream().min((Comparator.comparingInt(Hotel::getTotalPrice).thenComparing(Hotel::getRatings))).get();
        System.out.println("Hotel: " + hotel.getHotelName() + " Rating: " + hotel.getRatings() + " Price: " + hotel.getTotalPrice());
        return hotel.getTotalPrice();
    }


    public static void main(String[] args) {
        System.out.println(("Welcome to the Hotel Reservation Program"));

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel();
        hotelReservation.addCustomer();
    }
}
