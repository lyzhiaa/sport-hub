package kh.edu.istad_sport.feature.sport;

import jakarta.validation.Valid;
import kh.edu.istad_sport.feature.sport.dto.SportCreateRequest;
import kh.edu.istad_sport.feature.sport.dto.SportResponse;
import kh.edu.istad_sport.feature.sport.dto.SportUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sports")
public class SportController {
    private final SportService sportService;

    // create sport
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SportResponse createSport(@Valid @RequestBody SportCreateRequest sportCreateRequest) {
        return sportService.createSport(sportCreateRequest);
    }

    // get all sport
    @GetMapping
    List<SportResponse> getAllSports() {
        return sportService.getAllSports();
    }

    // get sport by uuid
    @GetMapping("/{uuid}")
    SportResponse getSportByUuid(@Valid @PathVariable String uuid) {
        return sportService.getSportByUuid(uuid);
    }

    // update sport
    @PatchMapping("/{uuid}")
    SportResponse updateSport(@Valid @PathVariable("uuid") String uuid,
                              @RequestBody SportUpdateRequest sportUpdateRequest) {
        return sportService.updateSport(uuid, sportUpdateRequest);
    }

    //delete sport by uuid
    @DeleteMapping("/{uuid}")
    void deleteSportByUuid(@Valid @PathVariable("uuid") String uuid) {
        sportService.deleteSportByUuid(uuid);
    }

}
