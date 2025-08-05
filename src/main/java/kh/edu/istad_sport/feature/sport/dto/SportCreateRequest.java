package kh.edu.istad_sport.feature.sport.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record SportCreateRequest(
        String name,
        String description,
        List<String> imageUrls,
        @NotBlank(message = "Category name is required")
        String categoryName
) {

}
