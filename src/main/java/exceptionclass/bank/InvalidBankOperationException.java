package exceptionclass.bank;

public class InvalidBankOperationException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidBankOperationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
