package by.agsr.monitorsensors.exceptions;


public class ValidationException extends ApiException {

    public ValidationException(ErrorType errorType, Object... params) {
        super(errorType, params);
    }
}
