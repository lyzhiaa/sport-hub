package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.SportCategory;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryCreateRequest;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryResponse;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportCategoryMapper {
    //create
    SportCategory fromSportCategoryCreateRequest(SportCategoryCreateRequest sportCategoryCreateRequest);
    // get all sport category
    List<SportCategoryResponse> toSportCategoryResponseList(List<SportCategory> sportCategories);
    //get by uuid
    SportCategoryResponse toSportCategoryResponse(SportCategory sportCategory);
    //update sport
    void fromSportCategoryUpdateRequest(SportCategoryUpdateRequest sportCategoryUpdateRequest,
                                        @MappingTarget SportCategory sportCategory);

}
