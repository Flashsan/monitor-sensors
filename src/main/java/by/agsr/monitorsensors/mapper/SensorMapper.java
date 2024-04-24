package by.agsr.monitorsensors.mapper;

import by.agsr.monitorsensors.dto.sensor.ResponseSensorDto;
import by.agsr.monitorsensors.dto.sensor.SensorDto;
import by.agsr.monitorsensors.entity.SensorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses = {RangeMapper.class})
public interface SensorMapper {
    SensorDto toSensorDto(SensorEntity sensorEntity);

    ResponseSensorDto toResponseSensorDto(SensorEntity sensorEntity);

    SensorEntity toSensorEntity(SensorDto sensorDto);


}
