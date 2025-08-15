package kh.edu.istad_sport.feature.favorite;

import kh.edu.istad_sport.domain.Favorite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoriteRepository extends CrudRepository<Favorite, String> {
    // Find all favorites by event UUID
    List<Favorite> findFavoriteByEventUuid(String eventUuid);

    // Find all favorites by sport UUID
    List<Favorite> findFavoriteBySportUuid(String sportUuid);

    // Find active (non-deleted) favorites by event UUID
    List<Favorite> findFavoriteByEventUuidAndIsDeletedFalse(String eventUuid);

    // Find active (non-deleted) favorites by sport UUID
    List<Favorite> findFavoriteBySportUuidAndIsDeletedFalse(String sportUuid);

    // Find all active (non-deleted) favorites
    List<Favorite> findByIsDeletedFalse(); // <-- NEW, used in getAllFavorites()

    // Check if an event is currently marked as favorite
    boolean existsByEventUuidAndIsFavoriteTrueAndIsDeletedFalse(String eventUuid);

    // Check if a sport is currently marked as favorite
    boolean existsBySportUuidAndIsFavoriteTrueAndIsDeletedFalse(String sportUuid);
}
