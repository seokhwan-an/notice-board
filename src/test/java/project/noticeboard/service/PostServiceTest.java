package project.noticeboard.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.noticeboard.domain.Post;
import project.noticeboard.repository.MemoryPostRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostServiceTest {
    PostService postService;
    MemoryPostRepository postRepository;

    @BeforeEach
    public void beforeEach(){
        postRepository = new MemoryPostRepository();
        postService = new PostService(postRepository);
    }

    @AfterEach
    public void afterEach(){
        postRepository.clear();
    }

    @Test
    public void 글_제목_검색() {
        //given
        Post post = new Post();
        post.setTitle("연습");
        post.setWriter("홍길동");
        post.setBody("연습글 입니다.");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setTitle("연습");
        post2.setWriter("홍길동");
        post2.setBody("연습글 입니다.");
        postRepository.save(post2);

        //when
        Optional<Post> result = postService.findbyTitle(post); //postService를 통해 가져온 게시글 목록

        // then
        Optional<Post> posts = Optional.ofNullable(postRepository.findByTitle(post.getTitle()).get()); //post
        assertEquals(result,posts);
    }

    @Test
    public void 글_작성자_검색() {
        //given
        Post post = new Post();
        post.setTitle("연습");
        post.setWriter("홍길동");
        post.setBody("연습글 입니다.");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setTitle("연습");
        post2.setWriter("홍길동");
        post2.setBody("연습글 입니다.");
        postRepository.save(post2);

        //when
        Optional<Post> result = postService.findbyWriter(post); //postService를 통해 가져온 게시글 목록

        // then
        Optional<Post> posts = Optional.ofNullable(postRepository.findByWriter(post.getWriter()).get()); //post
        assertEquals(result,posts);
    }

    @Test
    public void 글_전체() {
        //given
        Post post = new Post();
        post.setTitle("연습");
        post.setWriter("홍길동");
        post.setBody("연습글 입니다.");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setTitle("연습");
        post2.setWriter("홍길동");
        post2.setBody("연습글 입니다.");
        postRepository.save(post2);

        //when
        List<Post> result = postService.findAll(); //postService를 통해 가져온 게시글 목록

        // then
        List<Post> posts = postRepository.findAll(); //post
        assertEquals(result,posts);
    }

}
