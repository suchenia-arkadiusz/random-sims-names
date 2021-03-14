package pl.arusoftware.randomsimsname.data.exceptions;

public class AspirationNotFoundException extends Exception {
    public AspirationNotFoundException(String message) {
        super(message);
    }

    public AspirationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
