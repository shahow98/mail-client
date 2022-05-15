package top.shahow.exception;

/**
 * @author shahow
 */
public class MailClientException extends Exception{

    public MailClientException() {
        super();
    }

    public MailClientException(String message) {
        super(message);
    }

    public MailClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailClientException(Throwable cause) {
        super(cause);
    }

    protected MailClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
