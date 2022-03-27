package project.noticeboard.domain.post.repository;

import project.noticeboard.domain.post.Post;
import project.noticeboard.domain.post.repository.PostRepository;

import java.util.*;

public class MemoryPostRepository implements PostRepository {
    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return store.values().stream()
                .filter(post -> post.getTitle().equals(title))
                .findAny();
    }

    @Override
    public Optional<Post> findByWriter(String writer) {
        return store.values().stream()
                .filter(post -> post.getWriter().equals(writer))
                .findAny();
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    public void clear(){
        store.clear();
    }
}
