package kh.edu.istad_sport.feature.fileupload.dto;

import lombok.Builder;

@Builder
public record FileUploadResponse(
        String name,
        String uri,
        String contentType,
        Long size
) {
}
