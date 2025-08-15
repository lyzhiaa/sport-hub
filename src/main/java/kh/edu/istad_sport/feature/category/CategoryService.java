package kh.edu.istad_sport.feature.category;

import kh.edu.istad_sport.feature.category.dto.CategoryCreateRequest;
import kh.edu.istad_sport.feature.category.dto.CategoryResponse;
import kh.edu.istad_sport.feature.category.dto.CategoryUpdateRequest;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryCreateRequest;

import java.util.List;

public interface CategoryService {
    //create sport category
    CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest);
    // get all sport category
    List<CategoryResponse> getAllCategories();
    // get sport category by uuid
    CategoryResponse getCategoryByUuid(String uuid);
    // update sport category
    CategoryResponse updateCategory(String uuid, CategoryUpdateRequest categoryUpdateRequest);
    // delete sport category
    void deleteCategory(String uuid);
}
