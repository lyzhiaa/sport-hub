package kh.edu.istad_sport.feature.comment;

import kh.edu.istad_sport.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, String> {
    Optional<Comment> findByUuid(String uuid);
    List<Comment> findByEventUuid(String eventUuid);

}
