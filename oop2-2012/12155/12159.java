public class NotAValidStringException extends Exception {

    public NotAValidStringException() {}
    
    public NotAValidStringException(String message) {
	super(message);
    }
}
