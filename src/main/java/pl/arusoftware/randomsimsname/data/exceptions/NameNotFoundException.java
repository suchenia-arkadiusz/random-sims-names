package pl.arusoftware.randomsimsname.data.exceptions;

public class NameNotFoundException extends Exception {
    public NameNotFoundException(String message) {
        super(message);
    }

    public NameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
