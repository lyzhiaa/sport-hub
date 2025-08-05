package kh.edu.istad_sport.feature.favorite.dto;

import jakarta.annotation.Nullable;

public record FavoriteCreateRequest (
        @Nullable
        String sportUuid,
        @Nullable
        String eventUuid
) {
}
