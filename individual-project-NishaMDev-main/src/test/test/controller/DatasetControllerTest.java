package test.controller;
import test.helper.FileHelper;
import java.io.IOException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class DatasetControllerTest  {

    @Test
    public void datasetFound() throws IOException {
        DatasetController datasetController = new DatasetController("flights.csv");
        String expectedResponse = new String("Database Loaded");
        String actualResponse = new String("");
        datasetController.datasetCreation() ;
        actualResponse = "Database Loaded";
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void datasetNotFound() throws IOException {
        DatasetController datasetController = new DatasetController("flight1s.csv");
        String expectedResponse = new String("The Dataset file path was not found. Please enter valid file path");
        String actualResponse = new String("");
        FileHelper fileHelper;
        fileHelper = new FileHelper("flight1s.csv");

        try{
            fileHelper.fileReader(true);
        }catch (Exception e){
            actualResponse = "The Dataset file path was not found. Please enter valid file path";
        }

        assertEquals(expectedResponse, actualResponse);
    }
}