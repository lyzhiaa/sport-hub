package kh.edu.istad_sport.feature.favorite;

import kh.edu.istad_sport.feature.favorite.dto.FavoriteCreateRequest;
import kh.edu.istad_sport.feature.favorite.dto.FavoriteResponse;

import java.util.List;

public interface FavoriteService {
    //add sport or event to bookmark
    FavoriteResponse createFavorite(FavoriteCreateRequest favoriteCreateRequest);
    //get all bookmark
    List<FavoriteResponse> getAllFavorites();
    // un add to fav
    List<FavoriteResponse> unFavoriteByEvent(String eventUuid);

}
