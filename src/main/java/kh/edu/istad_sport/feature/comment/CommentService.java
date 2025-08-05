package kh.edu.istad_sport.feature.comment;

import kh.edu.istad_sport.domain.Comment;
import kh.edu.istad_sport.domain.Event;
import kh.edu.istad_sport.feature.comment.dto.CommentCreateRequest;
import kh.edu.istad_sport.feature.comment.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    // create comment
    CommentResponse createComment(CommentCreateRequest commentCreateRequest);
    // get all comment
    List<CommentResponse> getAllComments();
    // get comment by event uuid
    List<CommentResponse> getCommentByEventUuid(String eventUuid);
    // delete comment
    void deleteComment(String uuid);
}
