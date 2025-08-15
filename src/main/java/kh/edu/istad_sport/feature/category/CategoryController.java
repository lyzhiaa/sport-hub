package kh.edu.istad_sport.feature.category;

import jakarta.validation.Valid;
import kh.edu.istad_sport.feature.category.dto.CategoryCreateRequest;
import kh.edu.istad_sport.feature.category.dto.CategoryResponse;
import kh.edu.istad_sport.feature.category.dto.CategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // create sport category
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CategoryResponse createCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.createCategory(categoryCreateRequest);
    }

    // get all categories
    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getAllCategories();
    }

    // get category by uuid
    @GetMapping("/{uuid}")
    CategoryResponse getCategoryByUuid(@Valid @PathVariable("uuid") String uuid) {
        return categoryService.getCategoryByUuid(uuid);
    }

    // update sport category
    @PatchMapping("/{uuid}")
    CategoryResponse updateCategory(@PathVariable("uuid") String uuid, @Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        return categoryService.updateCategory(uuid, categoryUpdateRequest);
    }

    // delete sport category
    @DeleteMapping("/{uuid}")
    void deleteCategory(@PathVariable("uuid") String uuid) {
        categoryService.deleteCategory(uuid);
    }
}
