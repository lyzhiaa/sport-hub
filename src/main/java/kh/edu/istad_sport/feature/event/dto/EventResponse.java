package kh.edu.istad_sport.feature.event.dto;

import kh.edu.istad_sport.feature.category.dto.CategoryNameResponse;

import java.util.List;

public record EventResponse(
        Integer id,
        String uuid,
        String name,
        String description,
        CategoryNameResponse category,
        List<String> imageUrls,
        String locationName,
        Double latitude,
        Double longitude,
        String createdAt,
        String updatedAt
) {
}
