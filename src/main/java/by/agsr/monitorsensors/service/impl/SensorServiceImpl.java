package by.agsr.monitorsensors.service.impl;

import by.agsr.monitorsensors.dto.sensor.ResponseSensorDto;
import by.agsr.monitorsensors.dto.sensor.SensorDto;
import by.agsr.monitorsensors.entity.SensorEntity;
import by.agsr.monitorsensors.exceptions.ValidationException;
import by.agsr.monitorsensors.mapper.SensorMapper;
import by.agsr.monitorsensors.repository.SensorRepository;
import by.agsr.monitorsensors.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static by.agsr.monitorsensors.exceptions.ErrorType.SENSOR_NOT_FOUND;

@Service
@AllArgsConstructor
public class SensorServiceImpl
        implements SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    @Override
    public Page<ResponseSensorDto> getSensors(PageRequest pageRequest) {
        Page<SensorEntity> sensors = sensorRepository.findAll(pageRequest);
        List<ResponseSensorDto> sensorsContent =
                sensors.stream()
                        .map(sensorMapper::toResponseSensorDto)
                        .collect(Collectors.toList());
        return new PageImpl<>(sensorsContent, pageRequest, sensors.getTotalElements());
    }

    @Override
    public SensorDto findBySensorId(final Long id) {
        return sensorMapper
                .toSensorDto((sensorRepository.findById(id))
                        .orElseThrow(() -> new ValidationException(SENSOR_NOT_FOUND)));
    }

    @Override
    public SensorDto createSensor(SensorDto createSensorDto) {
        SensorEntity createSensor = sensorMapper.toSensorEntity(createSensorDto);
        sensorRepository.save(createSensor);
        return sensorMapper.toSensorDto(createSensor);
    }

    @Override
    public SensorDto updateSensor(SensorDto updateSensorDto ) {
        SensorEntity sensorEntity = findById(updateSensorDto.getId());
        SensorEntity updatedSensor = sensorRepository.save(sensorMapper.toSensorEntity(updateSensorDto));
        return sensorMapper.toSensorDto(updatedSensor);
    }

    @Override
    public void deleteBySensorId(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public List<ResponseSensorDto> searchSensors(String name, String model) {
        return sensorRepository.findByNameContainingIgnoreCaseAndModelContainingIgnoreCase(name, model)
                .stream()
                .map(sensorMapper::toResponseSensorDto)
                .toList();
    }

    private SensorEntity findById(final Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ValidationException(SENSOR_NOT_FOUND));
    }
}
