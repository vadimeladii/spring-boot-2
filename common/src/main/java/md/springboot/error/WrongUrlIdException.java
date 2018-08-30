package md.springboot.error;

public class WrongUrlIdException extends AbstractException {

    private static final String WRONG_URL_ID_MSG = "Object '%s' with id '%s' can't be edited with urlId '%s'";

    public WrongUrlIdException(Class<?> clazz, Object objectId, Object urlId) {
        super();
        getMessageException().setMessage(String.format(WRONG_URL_ID_MSG, clazz.getName(), objectId, urlId));
    }
}