package project.noticeboard.service;

import project.noticeboard.domain.Post;
import project.noticeboard.repository.MemoryPostRepository;
import project.noticeboard.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository;
    //DI 가능하게
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    // 제목 검색 기능
    public Optional<Post> findbyTitle(Post post){
         Optional<Post> result = Optional.ofNullable(postRepository.findByTitle(post.getTitle()).get());
         return result;
    }

    // 작성자 검색 기능
    public Optional<Post> findbyWriter(Post post){
        Optional<Post> result = Optional.ofNullable(postRepository.findByWriter(post.getWriter()).get());
        return result;
    }

    // 모든 글 반환 기능
    public List<Post> findAll(){
        List<Post> result = postRepository.findAll();
        return result;
    }
}
