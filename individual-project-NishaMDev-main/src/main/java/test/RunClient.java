package test;

import test.controller.DatasetController;
import test.controller.InputController;

import java.io.IOException;

public class RunClient {
    public static void main(String[] args) throws IOException {
        if(args.length==0){
            System.out.println("File path to Flight Input and Database not provided. Please enter one.");
            System.exit(0);
        }
        processStart(args);
    }
    private static void processStart(String[] args) throws IOException {
        DatasetController datasetController = new DatasetController(args[1]);
        datasetController.datasetCreation();
        startBooking(args[0]);
    }

    private static void startBooking(String path){
        InputController inputController = new InputController(path);
        if(inputController.startOrder()){
            inputController.checkFlight();
            inputController.generateOutputFile();
            }
        else {
            System.out.println("Input Booking file not found");
        }
    }
}

