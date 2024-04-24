package by.agsr.monitorsensors.service;

import by.agsr.monitorsensors.dto.sensor.ResponseSensorDto;
import by.agsr.monitorsensors.dto.sensor.SensorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface SensorService {

    Page<ResponseSensorDto> getSensors(PageRequest pageRequest);

    SensorDto findBySensorId(Long id);

    SensorDto createSensor(SensorDto sensorDto);

    SensorDto updateSensor(SensorDto breedDto);

    void deleteBySensorId(Long id);

    List<ResponseSensorDto> searchSensors(String name, String model);

}
