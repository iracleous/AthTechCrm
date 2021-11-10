package gr.athtech.athtechcrm.exception;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String description){
        super(description);
    }
}
