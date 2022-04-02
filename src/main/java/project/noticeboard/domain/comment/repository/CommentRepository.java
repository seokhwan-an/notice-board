package project.noticeboard.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.noticeboard.domain.comment.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
