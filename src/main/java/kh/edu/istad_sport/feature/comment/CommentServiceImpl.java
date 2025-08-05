package kh.edu.istad_sport.feature.comment;

import kh.edu.istad_sport.domain.Comment;
import kh.edu.istad_sport.feature.comment.dto.CommentCreateRequest;
import kh.edu.istad_sport.feature.comment.dto.CommentResponse;
import kh.edu.istad_sport.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ListableBeanFactory listableBeanFactory;

    // create comment
    @Override
    public CommentResponse createComment(CommentCreateRequest commentCreateRequest) {
        Comment comment = commentMapper.fromCommentCreateRequest(commentCreateRequest);
        comment.setUuid(UUID.randomUUID().toString());
        comment.setCreatedAt(String.valueOf(LocalDateTime.now()));

        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }

    // get all comment
    @Override
    public List<CommentResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        return commentMapper.toCommentResponseList(comments);
    }

    // get comment by event uuid
    @Override
    public List<CommentResponse> getCommentByEventUuid(String eventUuid) {
        List<Comment> comments = commentRepository.findByEventUuid(eventUuid);

        return commentMapper.toCommentResponseList(comments);
    }

    // delete comment by comment uuid
    @Override
    public void deleteComment(String uuid) {
        Comment comment = commentRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
}
