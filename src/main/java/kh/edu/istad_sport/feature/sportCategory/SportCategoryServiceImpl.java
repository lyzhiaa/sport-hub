package kh.edu.istad_sport.feature.sportCategory;

import kh.edu.istad_sport.domain.SportCategory;
import kh.edu.istad_sport.feature.sport.SportRepository;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryCreateRequest;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryResponse;
import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryUpdateRequest;
import kh.edu.istad_sport.mapper.SportCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SportCategoryServiceImpl implements SportCategoryService {

    private final SportCategoryRepository sportCategoryRepository;
    private final SportCategoryMapper sportCategoryMapper;
    private final SportRepository sportRepository;

    // create sport category
    @Override
    public SportCategoryResponse createSportCategory(SportCategoryCreateRequest sportCategoryCreateRequest) {
        // check if a sport category is already exist, do not allow to create
        if(sportCategoryRepository.existsByName(sportCategoryCreateRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This sport category already exists");
        }
        SportCategory category = sportCategoryMapper.fromSportCategoryCreateRequest(sportCategoryCreateRequest);
        category.setUuid(UUID.randomUUID().toString());
        category.setCreatedAt(String.valueOf(LocalDateTime.now()));
        category.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        sportCategoryRepository.save(category);
        return sportCategoryMapper.toSportCategoryResponse(category);
    }

    //get all sport categories
    @Override
    public List<SportCategoryResponse> getAllSportCategories() {
        List<SportCategory> sportCategories = sportCategoryRepository.findAll();
        return sportCategoryMapper.toSportCategoryResponseList(sportCategories);
    }

    // get sport category by uuid
    @Override
    public SportCategoryResponse getSportCategoryByUuid(String uuid) {
        SportCategory category = sportCategoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        category.setSports(sportRepository.findBySportCategoryUuid(uuid));
        return sportCategoryMapper.toSportCategoryResponse(category);
    }

    // update sport category by uuid
    @Override
    public SportCategoryResponse updateSportCategory(String uuid, SportCategoryUpdateRequest sportCategoryUpdateRequest) {
        // find sport category by uuid
        SportCategory category = sportCategoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        sportCategoryMapper.fromSportCategoryUpdateRequest(sportCategoryUpdateRequest, category);
        category.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        sportCategoryRepository.save(category);
        return sportCategoryMapper.toSportCategoryResponse(category);
    }

    // delete
    @Override
    public void deleteSportCategory(String uuid) {
        SportCategory category = sportCategoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport Category not found"));

        sportCategoryRepository.delete(category);
    }
}
