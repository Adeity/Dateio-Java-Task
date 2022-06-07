package eu.dateio.exceptions;

/**
 * Base for all application-specific exceptions.
 */
public class DateioException extends RuntimeException {

    public DateioException() {
    }

    public DateioException(String message) {
        super(message);
    }

    public DateioException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateioException(Throwable cause) {
        super(cause);
    }
}
