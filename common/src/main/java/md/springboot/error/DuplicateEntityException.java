package md.springboot.error;

public class DuplicateEntityException extends AbstractException {

    private static final String DUBLICATE_ENTITY = "Object %s with id '%s' already exists";

    public DuplicateEntityException(Class<?> clazz, Object objectId) {
        super();
        getMessageException().setMessage(String.format(DUBLICATE_ENTITY, clazz.getName(), objectId));
    }
}
