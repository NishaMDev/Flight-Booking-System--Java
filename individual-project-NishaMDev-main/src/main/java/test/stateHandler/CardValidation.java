package test.stateHandler;

import test.model.Booking;


public class CardValidation implements ValidationHandler{
    private ValidationHandler next= null;

    @Override
    public boolean validate(Booking items) {

            if ((items.getCardDetails().length() == 13 || items.getCardDetails().length() == 16) && items.getCardDetails().startsWith("4")){
                return true;
            }else if ((items.getCardDetails().length() == 16) &&
                    ((items.getCardDetails().startsWith("51"))
                    || items.getCardDetails().startsWith("52")
                    || items.getCardDetails().startsWith("53")
                    || items.getCardDetails().startsWith("54")
                    || items.getCardDetails().startsWith("55")))
        {
                return true;
            }else if ((items.getCardDetails().length() == 16) && items.getCardDetails().startsWith("6011")){
                return true;
            }else if ((items.getCardDetails().length() == 15) && (items.getCardDetails().startsWith("34")||
                    items.getCardDetails().startsWith("37"))){
                return true;
            }

            return false;
    }

    @Override
    public void nextHandler(ValidationHandler next) {
        this.next = next ;
    }



}

