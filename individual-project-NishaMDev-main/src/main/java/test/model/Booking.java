package test.model;

/* Detail of the input file after validation */

public class Booking {
    private String bookingName;
    private String flightNumber;
    private String seatCategory;
    private int noOfSeats;
    private String cardDetails;


    public Booking(String bookingName, String flightNumber, String seatCategory, int noOfSeats, String cardDetails) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.noOfSeats = noOfSeats;
        this.cardDetails = cardDetails;
    }

    public String getBookingName() {
        return bookingName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public String getCardDetails() {

        return cardDetails;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public String getIndex(){
        return getSeatCategory().toLowerCase().concat(getFlightNumber());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingName='" + bookingName + '\'' +
                ", flightNumber=" + flightNumber +
                ", seatCategory=" + seatCategory +
                ", noOfSeats=" + noOfSeats +
                ", cardDetails='" + cardDetails + '\'' +
                '}';
    }
}
