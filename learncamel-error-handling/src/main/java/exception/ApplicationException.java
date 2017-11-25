package exception;

/**
 * Created by ted on 24/11/17.
 */
public class ApplicationException extends Exception {


    String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicationException(String s) {
        this.message=s;
    }
}