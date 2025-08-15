package kh.edu.istad_sport.feature.favorite;

import kh.edu.istad_sport.domain.Favorite;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteCreateRequest;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteResponse;
import kh.edu.istad_sport.mapper.FavoriteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper;

    @Override
    public FavoriteResponse createFavorite(FavoriteCreateRequest request) {
        // Validate request
        if (request.eventUuid() == null && request.sportUuid() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Either eventUuid or sportUuid must be provided");
        }

        Favorite favorite = null;

        // Find existing favorite
        if (request.eventUuid() != null) {
            List<Favorite> favorites = favoriteRepository.findFavoriteByEventUuid(request.eventUuid());
            if (!favorites.isEmpty()) {
                favorite = favorites.get(0);
            }
        } else {
            List<Favorite> favorites = favoriteRepository.findFavoriteBySportUuid(request.sportUuid());
            if (!favorites.isEmpty()) {
                favorite = favorites.get(0);
            }
        }

        if (favorite != null) {
            // Toggle status
            boolean newStatus = !favorite.getIsFavorite();
            favorite.setUuid(UUID.randomUUID().toString());
            favorite.setIsFavorite(newStatus);
            favorite.setIsDeleted(!newStatus);
            favoriteRepository.save(favorite);
            return favoriteMapper.toFavoriteResponse(favorite);
        }

        // Create new favorite
        Favorite newFavorite = favoriteMapper.fromFavoriteCreateRequest(request);
        newFavorite.setCreatedAt(LocalDateTime.now());
        newFavorite.setIsDeleted(false);
        newFavorite.setIsFavorite(true);
        favoriteRepository.save(newFavorite);
        return favoriteMapper.toFavoriteResponse(newFavorite);
    }

    @Override
    public List<FavoriteResponse> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findByIsDeletedFalse();
        return favoriteMapper.toFavoriteResponseList(favorites);
    }

    @Override
    public List<FavoriteResponse> unFavoriteByEvent(String eventUuid) {
        List<Favorite> favorites = favoriteRepository.findFavoriteByEventUuidAndIsDeletedFalse(eventUuid);
        for (Favorite favorite : favorites) {
            favorite.setIsFavorite(false);
            favorite.setIsDeleted(true);
            favoriteRepository.save(favorite);
        }
        return favoriteMapper.toFavoriteResponseList(favorites);
    }
}
