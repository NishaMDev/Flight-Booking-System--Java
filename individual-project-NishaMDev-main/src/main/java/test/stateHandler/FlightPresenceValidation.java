package test.stateHandler;

import test.Database.Database;
import test.model.Booking;


public class FlightPresenceValidation implements ValidationHandler{
    private ValidationHandler next = null;

    @Override
    public boolean validate(Booking items) {
        Database database = Database.getInstance();
        if(!(database.getFlightMap().containsKey(items.getIndex()))) {
                return false;
        }
            return true;
    }

    @Override
    public void nextHandler(ValidationHandler next) {
        this.next = next ;
    }



}


