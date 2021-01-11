package exeption;

public class PostNotFaundExeption extends Exception {


    public PostNotFaundExeption() {
    }

    public PostNotFaundExeption(String message) {
        super(message);
    }

    public PostNotFaundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFaundExeption(Throwable cause) {
        super(cause);
    }

    public PostNotFaundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
