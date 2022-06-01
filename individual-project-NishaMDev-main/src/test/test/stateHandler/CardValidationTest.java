package test.stateHandler;
import test.Database.Database;
import test.model.Booking;


import org.junit.Test;
import test.model.Flight;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CardValidationTest {
    private ValidationHandler next= null;

    @Test
    public void validateCreditCardSuccess() {

        CardValidation cardValidation = new CardValidation();
        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ456",new Flight("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sam","SJ456","Economy",2, "5410000000000000"));

        for (Booking bookingItem : bookings) {
            boolean actualResponse = cardValidation.validate(bookingItem);
            //String[] expectedResponse = new String[0];
            assertEquals(true, actualResponse);
        }
    }

    @Test
    public void validateCreditCardFail() {

        CardValidation cardValidation = new CardValidation();
        Database database = Database.getInstance();
        String expectedResponse = new String("Please enter correct booking details for Sammy:invalid card details");
        String actualResponse = new String("");

        database.getFlightMap().put("economySJ450",new Flight("Economy","SJ450", 5, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sammy","SJ450","Economy",3, "54100000000"));

        for (Booking bookingItem : bookings) {
            if (!cardValidation.validate(bookingItem))
                actualResponse = "Please enter correct booking details for " + bookingItem.getBookingName() + ":invalid card details";
                assertEquals(expectedResponse, actualResponse);
        }
    }
}