package bg.fmi.web.lab.raceeventmanagement.mapper;

import bg.fmi.web.lab.raceeventmanagement.dto.RacerDto;
import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RacerMapper {
//    @Mapping(source = "name", target = "firstName")
//    @Mapping(target = "lastName", source = "lastName", ignore = true)
//    @Mapping(source = , target = , qualifiedByName = "imenametod")
    Racer mapFromDto(RacerDto racerDto);

    RacerDto mapToDto(Racer racer);
//
//    @Named("imenametod")
//    default ? methodName() {
//        return ?;
//    }
//
//    Team mapFromTeamDTO(TeamDTO teamDto);
//
//    List<Team> mapFromTeamDtos()
}
