package kh.edu.istad_sport.feature.event.dto;

import java.util.List;

public record EventResponse(
        Integer id,
        String uuid,
        String name,
        String description,
        List<String> imageUrls,
        String locationName,
        Double latitude,
        Double longitude,
        String createdAt,
        String updatedAt,
        Boolean disabled
) {
}
