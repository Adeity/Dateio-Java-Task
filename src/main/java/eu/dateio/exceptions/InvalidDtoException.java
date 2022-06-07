package eu.dateio.exceptions;

public class InvalidDtoException extends DateioException{

    public InvalidDtoException(String message) {
        super(message);
    }

    public InvalidDtoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static InvalidDtoException create() {
        return new InvalidDtoException("Received invalid DTO.");
    }
}
