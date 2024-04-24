package by.agsr.monitorsensors.mapper;

import by.agsr.monitorsensors.dto.range.RangeDto;
import by.agsr.monitorsensors.entity.RangeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RangeMapper {
    RangeDto toRangeDto(RangeEntity rangeEntity);

    RangeEntity toRangeEntity(RangeDto rangeDto);


}
