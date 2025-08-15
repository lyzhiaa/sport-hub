package kh.edu.istad_sport.feature.favorite;

import kh.edu.istad_sport.feature.favorite.dto.FavoriteCreateRequest;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    // Add or toggle favorite
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FavoriteResponse createFavorite(@RequestBody FavoriteCreateRequest request) {
        return favoriteService.createFavorite(request);
    }

    // Get all favorites
    @GetMapping
    public List<FavoriteResponse> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    // Unfavorite by event
    @DeleteMapping("/event/{eventUuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unFavoriteByEvent(@PathVariable String eventUuid) {
        favoriteService.unFavoriteByEvent(eventUuid);
    }
}
