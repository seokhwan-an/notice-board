package project.noticeboard.repository;

import project.noticeboard.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    Optional<Post> findByWriter(String writer);
    List<Post> findAll();
}
