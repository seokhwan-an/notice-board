package project.noticeboard.domain.comment.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import project.noticeboard.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
