package kh.edu.istad_sport.feature.sport.dto;

import kh.edu.istad_sport.feature.sportCategory.dto.SportCategoryNameResponse;

import java.util.List;

public record SportResponse (
        Integer id,
        String uuid,
        String name,
        SportCategoryNameResponse category,
        String description,
        List<String> imageUrls,
        String createdAt,
        String updatedAt,
        Boolean disabled
) {

}
