package kh.edu.istad_sport.feature.event.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EventCreateRequest(
        String name,
        String description,
        List<String> imageUrls,
        String locationName,
        Double latitude,
        Double longitude
) {
}
