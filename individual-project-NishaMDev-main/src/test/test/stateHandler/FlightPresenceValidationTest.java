package test.stateHandler;

import org.junit.Test;
import test.Database.Database;
import test.model.Booking;
import test.model.Flight;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class FlightPresenceValidationTest {

    @Test
    public void validateFlightPresence() {

        FlightPresenceValidation flightPresenceValidation = new FlightPresenceValidation();
        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ456",new Flight("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sam","SJ456","Economy",2, "5410000000000000"));

        for (Booking bookingItem : bookings) {
            boolean actualResponse = flightPresenceValidation.validate(bookingItem);
            //String[] expectedResponse = new String[0];
            assertEquals(true, actualResponse);
            System.out.println("Flight Availability Validated successfully");
        }
    }

    @Test
    public void validateFlightAbsence() {

        FlightPresenceValidation flightPresenceValidation = new FlightPresenceValidation();
        Database database = Database.getInstance();
        String expectedResponse = new String("Please enter correct booking details for Sammy:invalid flight details");
        String actualResponse = new String("");
        database.getFlightMap().put("economySJ450",new Flight("Economy","SJ450", 5, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sammy","SJ451","Economy",3, "5410000000000000"));

        for (Booking bookingItem : bookings) {
            if (!flightPresenceValidation.validate(bookingItem))
                actualResponse = "Please enter correct booking details for " + bookingItem.getBookingName() + ":invalid flight details";

            assertEquals(expectedResponse, actualResponse);
        }
    }
}