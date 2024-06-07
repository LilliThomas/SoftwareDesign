package exceptions;

public class ReflectionException extends RuntimeException {
    /**
     * Occurs when an expandable function is selected that cannot be loaded.
     * @param message a message is transferred during the call
     */
    public ReflectionException(String message) {
        super(message);
    }
}
