package rest.exceptions;

/**
 * This exception is thrown when Entity can't be found in repository
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super("Could not found entity" + message);
    }

    public EntityNotFoundException() {
        this("");
    }
}
