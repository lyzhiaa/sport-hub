package kh.edu.istad_sport.feature.sportCategory.dto;

import kh.edu.istad_sport.feature.sport.dto.SportResponse;

import java.util.List;

public record SportCategoryResponse(
        Integer id,
        String uuid,
        String name,
        String description,
        List<SportResponse> sports,
        String createdAt,
        String updatedAt
) {
}
