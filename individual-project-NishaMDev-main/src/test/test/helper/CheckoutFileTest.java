package test.helper;

import org.junit.Test;
import test.model.Invoice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CheckoutFileTest {
        private ArrayList<String> output = new ArrayList<>();
        Path filePath;

        @Test
        public void validateErrorFile() {
            CheckoutFile outputFile;
            Invoice currentInvoice = new Invoice();
            String expectedResponse = new String("Checkout File Saved");
            String actualResponse = new String("");

            currentInvoice.setBookingName("Sammy");
            currentInvoice.setFlightNumber("SJ450");
            currentInvoice.setSeatCategory("Economy");
            currentInvoice.setSeatsBooked(3);
            currentInvoice.setTotalPrice(1000.0);

            output.add(currentInvoice.toString());

            if (output.size() != 0) {

                try{
                    outputFile = new CheckoutFile();
                    outputFile.writeToFile(output);
                    outputFile.save(filePath);
                    actualResponse= "Checkout File Saved";
                }catch (IOException e){
                    actualResponse= "Checkout File Saved fail";
                    e.printStackTrace();
                }
            }
            assertEquals(expectedResponse, actualResponse);
        }
    }