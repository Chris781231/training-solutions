package collectionsqueue.jobdispatcher;

public class NoJobException extends  RuntimeException {

    public NoJobException(String message) {
        super(message);
    }
}
