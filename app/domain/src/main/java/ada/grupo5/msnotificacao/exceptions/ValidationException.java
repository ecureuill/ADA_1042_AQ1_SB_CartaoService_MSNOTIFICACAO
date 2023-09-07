package ada.grupo5.msnotificacao.exceptions;

public class ValidationException extends NoStacktraceException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
