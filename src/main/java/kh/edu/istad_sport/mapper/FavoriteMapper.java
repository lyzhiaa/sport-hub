package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.Favorite;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteCreateRequest;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {
    Favorite fromFavoriteCreateRequest(FavoriteCreateRequest favoriteCreateRequest);

    List<FavoriteResponse> toFavoriteResponseList(List<Favorite> favorites);

    FavoriteResponse toFavoriteResponse(Favorite favorite);
}
