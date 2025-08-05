package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.Comment;
import kh.edu.istad_sport.feature.comment.dto.CommentCreateRequest;
import kh.edu.istad_sport.feature.comment.dto.CommentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    // create comment
    Comment fromCommentCreateRequest(CommentCreateRequest commentCreateRequest);
    // get all review
    List<CommentResponse> toCommentResponseList(List<Comment> comments);
    // get comment by uuid
    CommentResponse toCommentResponse(Comment comment);
}
