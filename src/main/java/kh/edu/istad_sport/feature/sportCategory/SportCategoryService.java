package kh.edu.istad_sport.feature.sportCategory;

import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryCreateRequest;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryResponse;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryUpdateRequest;

import java.util.List;

public interface SportCategoryService {
    //create sport category
    SportCategoryResponse createSportCategory(SportCategoryCreateRequest sportCategoryCreateRequest);
    // get all sport category
    List<SportCategoryResponse> getAllSportCategories();
    // get sport category by uuid
    SportCategoryResponse getSportCategoryByUuid(String uuid);
    // update sport category
    SportCategoryResponse updateSportCategory(String uuid, SportCategoryUpdateRequest sportCategoryUpdateRequest);
    // delete sport category
    void deleteSportCategory(String uuid);
}
