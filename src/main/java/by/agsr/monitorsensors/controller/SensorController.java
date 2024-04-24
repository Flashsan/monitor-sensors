package by.agsr.monitorsensors.controller;

import by.agsr.monitorsensors.dto.sensor.ResponseSensorDto;
import by.agsr.monitorsensors.dto.sensor.SensorDto;
import by.agsr.monitorsensors.service.SensorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.agsr.monitorsensors.controller.util.RestApiPaths.SENSOR_API;

@Tag(name = "Sensor", description = "Sensor APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping(SENSOR_API)
public class SensorController {
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String DEFAULT_VALUE_PAGE = "0";
    public static final String DEFAULT_VALUE_SIZE = "5";

    private final SensorService sensorService;

    @GetMapping()
    public ResponseEntity<Page<ResponseSensorDto>> getSensors(
            @RequestParam(value = PAGE, defaultValue = DEFAULT_VALUE_PAGE) @Min(0) Integer page,
            @RequestParam(value = SIZE, defaultValue = DEFAULT_VALUE_SIZE) @Min(1) Integer size) {
        return new ResponseEntity<>(
                sensorService.getSensors(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorDto sensorDto) {
        return new ResponseEntity<>(sensorService.createSensor(sensorDto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<SensorDto> update(@RequestBody SensorDto sensorDto) {
        SensorDto sensorUpdateDto = sensorService.findBySensorId(sensorDto.getId());
        if (sensorUpdateDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SensorDto sensorAfterUpdateDto = sensorService.updateSensor(sensorUpdateDto);
        return new ResponseEntity<>(sensorAfterUpdateDto, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteSensor(@PathVariable("id") long id) {
        sensorService.deleteBySensorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ResponseSensorDto>> searchSensors(
            @RequestParam("queryName") @Size(min = 1) final String queryName,
            @RequestParam("queryModel") @Size(min = 1) final String queryModel) {
        List<ResponseSensorDto> sensorList = sensorService.searchSensors(queryName, queryModel);
        if (sensorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sensorList, HttpStatus.OK);
    }

}
