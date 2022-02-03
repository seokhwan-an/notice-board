package project.noticeboard.repository;

import project.noticeboard.domain.Post;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaPostRepository implements PostRepository{

    private final EntityManager em; // jpa의 동작 구성체

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Post save(Post post) {
        em.persist(post); //jpa가 insert query 다 만들어서 데이터베이스에 저장해줌
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        Post post = em.find(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        List<Post> posts = em.createQuery("select p from Post p where p.title = :title", Post.class)
                .setParameter("title",title)
                .getResultList();
        return posts.stream().findAny();
    }

    @Override
    public Optional<Post> findByWriter(String writer) {
        List<Post> posts = em.createQuery("select p from Post p where p.writer = :writer", Post.class)
                .setParameter("writer",writer)
                .getResultList();
        return posts.stream().findAny();
    }

    @Override
    public List<Post> findAll() {
       List<Post> posts = em.createQuery("select p from Post p", Post.class)
               .getResultList();
       return posts;
    }
}
