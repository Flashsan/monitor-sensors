package by.agsr.monitorsensors.dto.sensor;

import by.agsr.monitorsensors.dto.range.RangeDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SensorDto {
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 30)
    private String name;
    @NotEmpty
    @Size(max = 15)
    private String model;
    private String type;
    private RangeDto range;
    private String unit;
    @Size(max = 40)
    private String location;
    @Size(max = 200)
    private String description;
}
