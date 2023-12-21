package gt.com.tigo.accruedautomation.util.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super("No se ha podido encontrar el recurso solicitado.");
    }

}
