package exceptionclass.simpletime;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException(String message) {
        super(message);
    }
}
