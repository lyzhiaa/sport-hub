package kh.edu.istad_sport.feature.sportCategory;

import jakarta.validation.Valid;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryCreateRequest;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryResponse;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sport_categories")
@RequiredArgsConstructor
public class SportCategoryController {
    private final SportCategoryService sportCategoryService;

    // create sport category
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SportCategoryResponse createSportCategory(@Valid @RequestBody SportCategoryCreateRequest categoryCreateRequest) {
        return sportCategoryService.createSportCategory(categoryCreateRequest);
    }

    // get all categories
    @GetMapping
    public List<SportCategoryResponse> getCategories() {
        return sportCategoryService.getAllSportCategories();
    }

    // get category by uuid
    @GetMapping("/{uuid}")
    SportCategoryResponse getCategoryByUuid(@Valid @PathVariable("uuid") String uuid) {
        return sportCategoryService.getSportCategoryByUuid(uuid);
    }

    // update sport category
    @PatchMapping("/{uuid}")
    SportCategoryResponse updateCategory(@PathVariable("uuid") String uuid, @Valid @RequestBody SportCategoryUpdateRequest categoryUpdateRequest) {
        return sportCategoryService.updateSportCategory(uuid, categoryUpdateRequest);
    }

    // delete sport category
    @DeleteMapping("/{uuid}")
    void deleteCategory(@PathVariable("uuid") String uuid) {
        sportCategoryService.deleteSportCategory(uuid);
    }
}
