package by.agsr.monitorsensors.exceptions;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public abstract class ApiException extends RuntimeException{
    private final ErrorType errorType;
    private final Object[] params;
    private final ZonedDateTime time;


    public ApiException(ErrorType errorType, Object... params) {
        this.errorType = errorType;
        this.params = params;
        this.time = ZonedDateTime.now();
    }
}
