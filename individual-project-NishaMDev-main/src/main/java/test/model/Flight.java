package test.model;
/* Database file format */

public class  Flight {
    private String category;
    private String flightNumber;
    private int availableSeat;
    private double price;
    private String arrivalCity;
    private String departureCity;

    public Flight(String category, String flightNumber, int availableSeat, double price, String arrivalCity, String departureCity) {
        this.category = category;
        this.flightNumber = flightNumber;
        this.availableSeat = availableSeat;
        this.price = price;
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
    }

    public void Flight() {}


    public String getCategory() {
        return category;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public double getPrice() {
        return price;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "category='" + category + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", availableSeat='" + availableSeat + '\'' +
                ", price='" + price + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureCity=" + departureCity +
                '}';
    }
}

