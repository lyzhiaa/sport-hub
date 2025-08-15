package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.Category;
import kh.edu.istad_sport.feature.category.dto.CategoryCreateRequest;
import kh.edu.istad_sport.feature.category.dto.CategoryResponse;
import kh.edu.istad_sport.feature.category.dto.CategoryUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //create
    Category fromSportCategoryCreateRequest(CategoryCreateRequest sportCategoryCreateRequest);
    // get all sport category
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
    //get by uuid
    CategoryResponse toCategoryResponse(Category category);
    //update sport
    void fromCategoryUpdateRequest(CategoryUpdateRequest categoryUpdateRequest,
                                        @MappingTarget Category category);

}
