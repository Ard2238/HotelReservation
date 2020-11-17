package com.cg;

import java.util.*;

public class HotelReservation {
    private static final List<Hotel> hotelList = new ArrayList<Hotel>();
    private static final Map<String, Customer> customerHotelMap = new HashMap<>();

    public List<Hotel> getHotelList() { return hotelList; }
    public Map<String, Customer> getCustomerHotelMap() { return customerHotelMap; }

    Scanner input = new Scanner(System.in);

    private List<Hotel> addHotel(){
        System.out.println("Enter the Hotel's Name: ");
        String hotelName = input.nextLine();
        System.out.println("Enter the weekday rates for Regular customers: ");
        int weekday_rate = input.nextInt(); input.nextLine();
        System.out.println("Enter the weekend rates for Regular customers: ");
        int weekend_rate = input.nextInt(); input.nextLine();

        Hotel hotel = new Hotel(hotelName, weekday_rate, weekend_rate);
        hotelList.add(hotel);
        return hotelList;
    }
    private Map<String, Customer> addCustomer(){
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

    public static void main(String[] args) {
        System.out.println(("Welcome to the Hotel Reservation Program"));
        
    }
}
