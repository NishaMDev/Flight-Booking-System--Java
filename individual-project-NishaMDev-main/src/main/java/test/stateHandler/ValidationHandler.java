package test.stateHandler;


import test.model.Booking;
import java.util.ArrayList;

public interface ValidationHandler {
    boolean validate(Booking items);
    void nextHandler(ValidationHandler next);

}
