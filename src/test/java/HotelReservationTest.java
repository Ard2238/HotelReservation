import com.cg.Customer;
import com.cg.Hotel;
import com.cg.HotelReservation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Map;

public class HotelReservationTest {
    HotelReservation hotelReservation;

    @Before
    public void init(){
        hotelReservation = new HotelReservation();
    }

    @Test
    public void givenHotel_WhenAdded_ShoudlAddHotel(){
        Hotel hotel1 = new Hotel("LakeWood",110,90);
        Hotel hotel2 = new Hotel("BridgeWood",150,50);
        Hotel hotel3 = new Hotel("RidgeWood",220,150);

        hotelReservation.getHotelList().add(hotel1);
        hotelReservation.getHotelList().add(hotel2);
        hotelReservation.getHotelList().add(hotel3);
        Assert.assertEquals(3, hotelReservation.getHotelList().size());
    }
    @Test
    public void givenCustomer_WhenAddedToHotel_ShouldAddCustomer() {
        Customer customer1 = new Customer("Regular", "Abhishek Das");
        Customer customer2 = new Customer("Regular", "Sumit Sharma");

        hotelReservation.getCustomerHotelMap().put("LakeWood", customer1);
        hotelReservation.getCustomerHotelMap().put("BridgeWood", customer2);
        Assert.assertEquals(2, hotelReservation.getCustomerHotelMap().size());
    }

    @Test
    public void givenDateRange_ReturnCheapestHotel() throws ParseException {
        givenHotel_WhenAdded_ShoudlAddHotel();
        Map<String, Long> retrievedHotels = hotelReservation.findCheapestHotel("Regular", "01-01-2000","10-01-2000");
        long value = retrievedHotels.get("LakeWood");
        Assert.assertEquals(1020, value);
    }

    @Test
    public void givenDateRange_ReturnCheapestHotel_MoreThanOne() throws ParseException {
        givenHotel_WhenAdded_ShoudlAddHotel();
        hotelReservation.findCheapestHotel("Regular", "11-09-2020", "12-09-2020");
    }
}
