package kh.edu.istad_sport.feature.event.dto;

import java.util.List;

public record EventUpdateRequest(
        String name,
        String description,
        List<String> imageUrls,
        String locationName,
        Double latitude,
        Double longitude
) {
}
