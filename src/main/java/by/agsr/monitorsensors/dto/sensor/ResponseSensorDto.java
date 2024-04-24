package by.agsr.monitorsensors.dto.sensor;

import by.agsr.monitorsensors.dto.range.RangeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseSensorDto {
    private String name;
    private String model;
    private String type;
    private RangeDto range;
    private String unit;
    private String location;
    private String description;
}
