package rest.exceptions;

/**
 * This exception is thrown when Entity can't be found in repository
 */
public class FieldOrSetterNotFoundException extends RuntimeException {
    public FieldOrSetterNotFoundException(String message) {
        super("Could not find setter for field " + message);
    }

    // for using in streams
    public FieldOrSetterNotFoundException() {
        this("");
    }
}
