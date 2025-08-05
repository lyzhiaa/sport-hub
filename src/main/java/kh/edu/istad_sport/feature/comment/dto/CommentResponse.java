package kh.edu.istad_sport.feature.comment.dto;

public record CommentResponse(
        Integer id,
        String uuid,
        String sportUuid,
//        String userUuid,
        String comment,
        String createdAt
) {
}
