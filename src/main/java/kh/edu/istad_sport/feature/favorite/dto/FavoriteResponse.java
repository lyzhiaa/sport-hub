package kh.edu.istad_sport.feature.favorite.dto;

public record FavoriteResponse(
        String id,
        String uuid,
        String sportUuid,
        String eventUuid,
        Boolean isDeleted,
        Boolean isFavorite
) {
}
