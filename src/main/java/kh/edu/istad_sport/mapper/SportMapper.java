package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.Sport;
import kh.edu.istad_sport.feature.sport.dto.SportCreateRequest;
import kh.edu.istad_sport.feature.sport.dto.SportResponse;
import kh.edu.istad_sport.feature.sport.dto.SportUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportMapper {
    // create sport request to sport entity
    @Mapping(ignore = true, target = "id")
    Sport fromSportCreateRequest(SportCreateRequest sportCreateRequest);
    // search sport by name
    @Mapping(target = "category", source = "sportCategory")
    SportResponse toSportResponse(Sport sport);
    // all sports to sport response
    List<SportResponse> toSportResponseList(List<Sport> sports);
    // update sport request to place entity
    void fromSportUpdateRequest(SportUpdateRequest sportUpdateRequest,@MappingTarget Sport sport);
}
