package kh.edu.istad_sport.feature.comment.dto;

public record CommentResponse(
        Integer id,
        String uuid,
        String eventUuid,
//        String userUuid,
        String comment,
        String createdAt
) {
}
