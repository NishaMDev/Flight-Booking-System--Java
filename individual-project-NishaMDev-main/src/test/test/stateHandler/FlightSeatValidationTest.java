package test.stateHandler;
import test.Database.Database;
import test.model.Booking;
import test.model.Flight;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class FlightSeatValidationTest {
    private FlightSeatValidation flightSeatValidation = new FlightSeatValidation();

    @Test
    public void validateFlightSeatPresence() {

        FlightSeatValidation flightSeatValidation = new FlightSeatValidation();
        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ456",new Flight("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sam","SJ456","Economy",2, "5410000000000000"));

        for (Booking bookingItem : bookings) {
            boolean actualResponse = flightSeatValidation.validate(bookingItem);
            //String[] expectedResponse = new String[0];
            assertEquals(true, actualResponse);
            System.out.println("Seats Validated successfully");
        }
    }

    @Test
    public void validateFlightSeatAbsence() {

        FlightSeatValidation flightSeatValidation = new FlightSeatValidation();
        Database database = Database.getInstance();
        String expectedResponse = new String("Please enter correct booking details for Sammy:seats unavailable");
        String actualResponse = new String("");

        database.getFlightMap().put("economySJ450",new Flight("Economy","SJ450", 1, 200, "San Jose", "New York"));
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("Sammy","SJ450","Economy",3, "5410000000000000"));

        for (Booking bookingItem : bookings) {
            if (!flightSeatValidation.validate(bookingItem))
                actualResponse = "Please enter correct booking details for " + bookingItem.getBookingName() + ":seats unavailable";
            assertEquals(expectedResponse, actualResponse);

        }
    }
}