package test.controller;

import org.junit.Test;
import test.Database.Database;
import test.model.Flight;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class InputControllerTest {


    @Test
    public void startOrderPass() {
        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ456", new Flight("Economy", "SJ456", 5, 200, "San Jose", "New York"));
        String expectedResponse = new String("Files parsed successfully");
        String actualResponse = new String("");

        InputController inputController = new InputController("InputFile.csv");
        if (inputController.startOrder()) {
            actualResponse = "Files parsed successfully";
        }
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void startOrderFail() {
        String expectedResponse = new String("Input Booking file not found");
        String actualResponse = new String("");

        InputController inputController = new InputController("InputFileA1.csv");
        if (inputController.startOrder()){
            actualResponse = "Start Order processed";
        }
        else {
            actualResponse = "Input Booking file not found";
        }

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void checkFlight() {

        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ450", new Flight("Economy", "SJ450", 5, 200, "San Jose", "New York"));
        String expectedResponse = new String("All booking processed");
        String actualResponse = new String("");
        InputController inputController = new InputController("InputFile.csv");
        if (!inputController.startOrder())
            actualResponse = "Input Booking file not found";
        else {
            inputController.checkFlight();
            actualResponse = "All booking processed";
        }
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void generateOutputFile() {

        Database database = Database.getInstance();
        database.getFlightMap().put("economySJ450", new Flight("Economy", "SJ450", 5, 200, "San Jose", "New York"));
        String expectedResponse = new String("All booking processed");
        String actualResponse = new String("");
        InputController inputController = new InputController("InputFile.csv");
        if (inputController.startOrder()) {
            inputController.checkFlight();
            inputController.generateOutputFile();
            actualResponse= "All booking processed";
        } else {
            actualResponse = "Input Booking file not found";
        }
        expectedResponse = "All booking processed";
        assertEquals(expectedResponse, actualResponse);
    }
}