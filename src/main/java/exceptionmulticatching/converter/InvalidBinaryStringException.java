package exceptionmulticatching.converter;

public class InvalidBinaryStringException extends RuntimeException {

    public InvalidBinaryStringException(Throwable cause) {
        super(cause);
    }
}
