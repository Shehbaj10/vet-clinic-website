package au.edu.rmit.sept.webapp.exceptions;

public class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super(message);
    }
}

