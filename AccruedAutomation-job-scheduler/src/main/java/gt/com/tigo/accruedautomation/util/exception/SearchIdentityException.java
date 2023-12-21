package gt.com.tigo.accruedautomation.util.exception;

public class SearchIdentityException extends Exception {

    public SearchIdentityException() {
        super("Error al recuperar la información del usuario.");
    }

    public SearchIdentityException(String message) {
        super(message);
    }

}
