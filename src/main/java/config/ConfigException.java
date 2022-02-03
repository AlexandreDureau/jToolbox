package config;

public class ConfigException extends Exception {

    protected String message;
    protected  Throwable cause;

    public ConfigException(String message) {
        this.message = message;
    }

    public ConfigException(String message, Throwable cause) {
        this.cause = cause;
        this.message = message + " ("  + cause.getMessage() + ")";
    }

    @Override
    public String getMessage() {
        return message;
    }
}