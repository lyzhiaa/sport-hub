package kh.edu.istad_sport.feature.category.dto;

import kh.edu.istad_sport.feature.event.dto.EventResponse;
import kh.edu.istad_sport.feature.sport.dto.SportResponse;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String uuid,
        String name,
        String description,
        List<EventResponse> events,
        String createdAt,
        String updatedAt
) {
}
