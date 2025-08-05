package kh.edu.istad_sport.feature.comment.dto;

import jakarta.persistence.Column;

public record CommentCreateRequest(
        @Column(nullable = false)
        String sportUuid,

        @Column(nullable = false)
        String comment
) {
}
