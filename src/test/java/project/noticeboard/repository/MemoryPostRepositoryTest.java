package project.noticeboard.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import project.noticeboard.domain.Post;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryPostRepositoryTest {
    MemoryPostRepository repository = new MemoryPostRepository();

    @AfterEach
    public void afterEach(){
        repository.clear();
    }

    @Test
    public void save(){
        //given
        Post post = new Post();
        post.setTitle("연습");
        post.setBody("연습 글 입니다.");
        post.setWriter("홍길동");

        //when
        repository.save(post);

        //then
        Post result = repository.findById(post.getId()).get();
        assertThat(result).isEqualTo(post);
    }

    @Test
    public void findbyId(){
        //given
        Post post1 = new Post();
        post1.setTitle("연습1");
        post1.setBody("연습1 글 입니다.");
        post1.setWriter("홍길동");
        repository.save(post1);

        Post post2 = new Post();
        post2.setTitle("연습2");
        post2.setBody("연습2 글 입니다.");
        post2.setWriter("홍길동");
        repository.save(post2);

        //when
        Post result = repository.findById(post1.getId()).get();

        //then
        assertThat(result).isEqualTo(post1);
    }

    @Test
    public void findbyTitle(){
        //given
        Post post1 = new Post();
        post1.setTitle("연습1");
        post1.setBody("연습1 글 입니다.");
        post1.setWriter("홍길동");
        repository.save(post1);

        Post post2 = new Post();
        post2.setTitle("연습2");
        post2.setBody("연습2 글 입니다.");
        post2.setWriter("홍길동");
        repository.save(post2);

        //when
        Post result = repository.findByTitle(post1.getTitle()).get();

        //then
        assertThat(result).isEqualTo(post1);
    }

    @Test
    public void findbyWriter(){
        //given
        Post post1 = new Post();
        post1.setTitle("연습1");
        post1.setBody("연습1 글 입니다.");
        post1.setWriter("홍길동");
        repository.save(post1);

        Post post2 = new Post();
        post2.setTitle("연습2");
        post2.setBody("연습2 글 입니다.");
        post2.setWriter("홍길동");
        repository.save(post2);

        //when
        Post result = repository.findByWriter(post1.getWriter()).get();

        //then
        assertThat(result).isEqualTo(post1);
    }

    @Test
    public void findAll(){
        //given
        Post post1 = new Post();
        post1.setTitle("연습1");
        post1.setBody("연습1 글 입니다.");
        post1.setWriter("홍길동");
        repository.save(post1);

        Post post2 = new Post();
        post2.setTitle("연습2");
        post2.setBody("연습2 글 입니다.");
        post2.setWriter("홍길동");
        repository.save(post2);

        //when
        List<Post> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
