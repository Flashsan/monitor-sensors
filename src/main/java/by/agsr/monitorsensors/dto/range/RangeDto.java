package by.agsr.monitorsensors.dto.range;

import by.agsr.monitorsensors.dto.sensor.SensorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RangeDto {
    private long id;
    private double from;
    private double to;
    private SensorDto sensor;
}
