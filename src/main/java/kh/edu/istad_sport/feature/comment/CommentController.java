package kh.edu.istad_sport.feature.comment;

import jakarta.validation.Valid;
import kh.edu.istad_sport.feature.comment.dto.CommentCreateRequest;
import kh.edu.istad_sport.feature.comment.dto.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    // create review
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CommentResponse createComment(@Valid @RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createComment(commentCreateRequest);
    }
    // get all reviews
    @GetMapping
    List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }
    // get review by uuid
    @GetMapping("/events/{uuid}")
    List<CommentResponse> getCommentByEventUuid(@Valid @PathVariable("uuid") String uuid) {
        return commentService.getCommentByEventUuid(uuid);
    }

    // delete review by uuid
    @DeleteMapping("/{uuid}")
    void deleteComment(@Valid @PathVariable("uuid") String uuid) {
        commentService.deleteComment(uuid);
    }

}
