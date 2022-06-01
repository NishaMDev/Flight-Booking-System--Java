package test.model;
/* File format of output csv file */


public class Invoice {
    private String bookingName;
    private String flightNumber;
    private String seatCategory;
    private int seatsBooked;
    private double totalPrice;

    public Invoice() {}

    public String getBookingName() {
        return bookingName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public double getTotalPrice() {
        return totalPrice;
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

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /* write format*/

    @Override
    public String toString() {
        return ""+ bookingName +
                ", " + flightNumber +
                "," + seatCategory +
                "," + seatsBooked +
                "," + totalPrice + "";
    }
}



