package by.agsr.monitorsensors.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
public class ApiErrorResponse {
    private HttpStatus status;
    private String title;
    private String description;
    @JsonFormat
            (pattern = "yyyy-MM-dd hh:mm:ss")
    private ZonedDateTime time;

    public ApiErrorResponse(HttpStatus status, String title, String description) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.time = ZonedDateTime.now();
    }
}
