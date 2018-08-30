package md.springboot.error;

import md.springboot.util.FieldName;

/**
 * Created by veladii on 30.08.2018
 */
public class ValueExistsException extends AbstractException {

    private static final String VALUES_EXIST_MSG = "Object %s with field %s should be null";

    public ValueExistsException(Class<?> clazz, FieldName fieldName) {
        super();
        getMessageException().setMessage(String.format(VALUES_EXIST_MSG, clazz.getName(), fieldName.name()));
    }
}
