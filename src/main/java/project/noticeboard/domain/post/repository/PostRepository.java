package project.noticeboard.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.noticeboard.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
