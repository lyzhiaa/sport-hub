package kh.edu.istad_sport.feature.sport;

import kh.edu.istad_sport.feature.sport.dto.SportCreateRequest;
import kh.edu.istad_sport.feature.sport.dto.SportResponse;
import kh.edu.istad_sport.feature.sport.dto.SportUpdateRequest;

import java.util.List;

public interface SportService {
    //create sport
    SportResponse createSport(SportCreateRequest sportCreateRequest);
    //get all sport
    List<SportResponse> getAllSports();
    //get place by uuid
    SportResponse getSportByUuid(String uuid);
    //update sport
    SportResponse updateSport(String uuid, SportUpdateRequest sportUpdateRequest);
    //delete place
    void deleteSportByUuid(String uuid);
    // disable place by uuid
    void disablePlaceByUuid(String uuid);
    // enable place by uuid
    void enablePlaceByUuid(String uuid);


}