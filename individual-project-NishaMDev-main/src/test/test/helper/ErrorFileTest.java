package test.helper;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

import java.util.ArrayList;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ErrorFileTest {
    private ArrayList<String> error = new ArrayList<>();
    Path filePath;

    @Test
    public void validateErrorFile() {
        ErrorFile outputFile;
        outputFile = new ErrorFile();
        String expectedResponse = new String("Error File Saved");
        String actualResponse = new String("");
        error.add("Please enter correct booking details for Sam:invalid flight details");

        if (error.size() != 0) {

            try{
                outputFile = new ErrorFile();
                outputFile.writeToFile(error);
                outputFile.save(filePath);
                actualResponse= "Error File Saved";
            }catch (IOException e){
                actualResponse= "Error File Saved fail";
                e.printStackTrace();
            }
        }
        assertEquals(expectedResponse, actualResponse);
    }
}