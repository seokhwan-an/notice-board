package project.noticeboard.domain.comment.repository;

import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.post.Post;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaCommentRepository implements CommentRepository {
    private final EntityManager em; // jpa의 동작 구성체

    public JpaCommentRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public void save(Comment comment) {
        em.persist(comment);
        return;
    }

    @Override
    public Optional<Comment> findById(long id) {
        Comment comment = em.find(Comment.class, id);
        return Optional.ofNullable(comment);
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
        return comments;
    }

    @Override
    public void delete(Long id) {
        Optional<Comment> comment = findById(id);
        comment.ifPresent(value -> em.remove(value));
    }
}
