package project.noticeboard.domain.comment.repository;

import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    void save(Comment comment);
    Optional<Comment> findById(long id);
    List<Comment> findAll();
    void delete(Long id);
}
