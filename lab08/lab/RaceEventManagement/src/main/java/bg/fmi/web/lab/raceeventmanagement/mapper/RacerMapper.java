package bg.fmi.web.lab.raceeventmanagement.mapper;

import bg.fmi.web.lab.raceeventmanagement.dto.RacerDto;
import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RacerMapper {
    @Mapping(source = "name", target = "firstName")
    Racer mapFromDto(RacerDto racerDto);

    @Mapping(source = "firstName", target = "name")
    RacerDto mapToDto(Racer racer);
}
