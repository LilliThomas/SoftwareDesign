package exceptions;

public class DivisionException extends RuntimeException {
    /**
     * occurs when divided by 0
     * @param message a message is transferred during the call
     */
    public DivisionException(String message) {
        super(message);
    }

}
