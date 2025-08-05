package kh.edu.istad_sport.feature.sport;

import kh.edu.istad_sport.domain.Sport;
import kh.edu.istad_sport.domain.SportCategory;
import kh.edu.istad_sport.feature.sport.dto.SportCreateRequest;
import kh.edu.istad_sport.feature.sport.dto.SportResponse;
import kh.edu.istad_sport.feature.sport.dto.SportUpdateRequest;
import kh.edu.istad_sport.feature.sportCategory.SportCategoryRepository;
import kh.edu.istad_sport.mapper.SportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements SportService {

    private final SportMapper sportMapper;
    private final SportRepository sportRepository;
    private final SportCategoryRepository categoryRepository;

    // create sport
    @Override
    public SportResponse createSport(SportCreateRequest sportCreateRequest) {
        //do not allow to create, if the name is already exist
        if ( sportRepository.existsByName(sportCreateRequest.name())) {
            throw new RuntimeException("Sport with name " + sportCreateRequest.name() + " already exists");
        }
        // Check if category exists, otherwise create a new one
        SportCategory category = categoryRepository.findByName(sportCreateRequest.categoryName())
                .orElseGet(() -> {
                    SportCategory newCategory = new SportCategory();
                    newCategory.setName(sportCreateRequest.categoryName());
                    return categoryRepository.save(newCategory);
                });
        // Convert DTO to Entity using Mapper
        Sport sport = sportMapper.fromSportCreateRequest(sportCreateRequest);
        sport.setUuid(java.util.UUID.randomUUID().toString());
        sport.setCreatedAt(String.valueOf(LocalDateTime.now()));
        sport.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        sport.setDisabled(false);
        sport.setSportCategory(category);

        sportRepository.save(sport);
        return sportMapper.toSportResponse(sport);
    }

    // get all sport
    @Override
    public List<SportResponse> getAllSports() {
        List<Sport> sports = sportRepository.findAll();
        return sportMapper.toSportResponseList(sports);
    }

    // find sport by uuid
    @Override
    public SportResponse getSportByUuid(String uuid) {
        Sport sport = sportRepository.findByUuid(uuid)
                .orElseThrow(()-> new RuntimeException("Sport with uuid " + uuid + " does not exist"));
        return sportMapper.toSportResponse(sport);
    }

    // update sport by uuid
    @Override
    public SportResponse updateSport(String uuid, SportUpdateRequest sportUpdateRequest) {
        // find sport that willing to update
        Sport sport = sportRepository.findByUuid(uuid)
                .orElseThrow(()-> new RuntimeException("Sport with uuid " + uuid + " does not exist"));

        //
        sportMapper.fromSportUpdateRequest(sportUpdateRequest, sport);
        sport.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        sportRepository.save(sport);
        return sportMapper.toSportResponse(sport);
    }

    // delete sport
    @Override
    public void deleteSportByUuid(String uuid) {
        // find sport that willing to delete
        Sport sport = sportRepository.findByUuid(uuid)
                .orElseThrow(()-> new RuntimeException("Sport with uuid " + uuid + " does not exist"));
        sportRepository.delete(sport);
    }

    // disable sport
    @Override
    public void disablePlaceByUuid(String uuid) {

    }

    // enable sport
    @Override
    public void enablePlaceByUuid(String uuid) {

    }
}
