package kh.edu.istad_sport.feature.category;

import kh.edu.istad_sport.domain.Category;
import kh.edu.istad_sport.feature.category.dto.CategoryCreateRequest;
import kh.edu.istad_sport.feature.category.dto.CategoryResponse;
import kh.edu.istad_sport.feature.category.dto.CategoryUpdateRequest;
import kh.edu.istad_sport.feature.event.EventRepository;
import kh.edu.istad_sport.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final EventRepository eventRepository;

    // create sport category
    @Override
    public CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        // check if a sport category is already exist, do not allow to create
        if(categoryRepository.existsByName(categoryCreateRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This sport category already exists");
        }
        Category category = categoryMapper.fromSportCategoryCreateRequest(categoryCreateRequest);
        category.setUuid(UUID.randomUUID().toString());
        category.setCreatedAt(String.valueOf(LocalDateTime.now()));
        category.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(category);
    }

    //get all sport categories
    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryResponseList(categories);
    }

    // get sport category by uuid
    @Override
    public CategoryResponse getCategoryByUuid(String uuid) {
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        category.setEvents(eventRepository.findByCategoryUuid(uuid));
        return categoryMapper.toCategoryResponse(category);
    }

    // update sport category by uuid
    @Override
    public CategoryResponse updateCategory(String uuid, CategoryUpdateRequest categoryUpdateRequest) {
        // find sport category by uuid
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        categoryMapper.fromCategoryUpdateRequest(categoryUpdateRequest, category);
        category.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(category);
    }

    // delete
    @Override
    public void deleteCategory(String uuid) {
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        categoryRepository.delete(category);
    }
}
