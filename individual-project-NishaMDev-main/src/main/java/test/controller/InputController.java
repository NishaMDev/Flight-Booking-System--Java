package test.controller;

import test.Database.Database ;
import test.helper.FileHelper;
import test.model.Flight;
import test.model.Invoice;
import test.model.Booking;
import test.stateHandler.CardValidation;
import test.stateHandler.FlightPresenceValidation;
import test.stateHandler.FlightSeatValidation;
import test.stateHandler.ValidationHandler;

import java.io.IOException;
import java.util.ArrayList;

public class InputController {

    private Database database = Database.getInstance();
    private Invoice currentInvoice = new Invoice();
    private FileHelper fileHelper;
    private ArrayList<String> output = new ArrayList<>();
    private ArrayList<String> error =    new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private double total = 0;
    private boolean errorFlag = false;


    public InputController(String filePath){
        fileHelper = new FileHelper(filePath);
    }

    private void getItems(ArrayList<String> fileContent){
        for(String line: fileContent){
            String[] item = line.split(",");
            bookings.add(new Booking(item[0],item[1],item[2],Integer.parseInt(item[3]),item[4].replaceAll("\\s+","")));
        }
    }

    public boolean startOrder() {
        try{
            fileHelper.fileReader(true);
        }catch (Exception e){
            return false;
        }

        getItems(fileHelper.getContentFile());
        return true;
    }

    public void checkFlight() {
        ValidationHandler flightPresence = new FlightPresenceValidation();
        ValidationHandler flightSeat = new FlightSeatValidation();
        ValidationHandler cardCheck = new CardValidation();
        flightPresence.nextHandler(flightSeat);
        flightSeat.nextHandler(cardCheck);

        for (Booking bookingItem : bookings) {
            errorFlag = false;
            if (!flightPresence.validate(bookingItem)) {
                errorFlag = true;
                error.add("Please enter correct booking details for " + bookingItem.getBookingName() + ":invalid flight details");
            } else if (!flightSeat.validate(bookingItem)) {
                errorFlag = true;
                error.add("Please enter correct booking details for " + bookingItem.getBookingName() + ":seats unavailable");
            }

            if (!errorFlag) {
                calculateTotal(bookingItem);
                if (getTotal() > 0) {
                    if (!cardCheck.validate(bookingItem)) {
                        error.add("Please enter correct booking details for " + bookingItem.getBookingName() + ":invalid card details");

                    } else {
                        updateAvailableSeat(bookingItem);
                        updateCurrentInvoice(bookingItem);
                        resetCurrentInvoice(currentInvoice);
                    }
                }
            }
        }
    }

    private void updateAvailableSeat(Booking bookingItem) {
        Flight flight = database.getFlightMap().get(bookingItem.getIndex());
        flight.setAvailableSeat(flight.getAvailableSeat() - bookingItem.getNoOfSeats());
    }

    private void updateCurrentInvoice(Booking bookingItem) {
        currentInvoice.setBookingName(bookingItem.getBookingName());
        currentInvoice.setFlightNumber(bookingItem.getFlightNumber());
        currentInvoice.setSeatCategory(bookingItem.getSeatCategory());
        currentInvoice.setSeatsBooked(bookingItem.getNoOfSeats());
        output.add(currentInvoice.toString());
    }

    private void resetCurrentInvoice( Invoice currentInvoice){
        currentInvoice.setSeatsBooked(0);
        currentInvoice.setSeatCategory("");
        currentInvoice.setBookingName("");
        currentInvoice.setFlightNumber("");
        currentInvoice.setTotalPrice(0.0);
    }

    private void calculateTotal( Booking bookingItem) {
        currentInvoice.setTotalPrice(0.0);
        total = bookingItem.getNoOfSeats() * database.getFlightMap().get(bookingItem.getIndex()).getPrice();
        currentInvoice.setTotalPrice(total);
    }


    private double getTotal() {
        return currentInvoice.getTotalPrice();
    }

    public void generateOutputFile(){

        if(output.size()!=0){
            try{
                fileHelper.writeOutput(output,false);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(error.size()!=0){
            try{
                fileHelper.writeOutput(error,true);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}


