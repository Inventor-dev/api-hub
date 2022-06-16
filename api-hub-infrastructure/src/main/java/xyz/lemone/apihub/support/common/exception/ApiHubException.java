package xyz.lemone.apihub.support.common.exception;

/**
 * ApiHubException.
 *
 * @author lemon
 */
public class ApiHubException extends RuntimeException {
    public ApiHubException() {
    }

    public ApiHubException(String message) {
        super(message);
    }

    public ApiHubException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiHubException(Throwable cause) {
        super(cause);
    }

    public ApiHubException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
