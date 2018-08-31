package md.springboot.error;

public class IllegalArgumentException extends AbstractException {

    public IllegalArgumentException(String message) {
        super();
        getMessageException().setMessage(message);
    }
}