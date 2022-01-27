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
    // 저장 기능
    public Long save(Post post){
        postRepository.save(post);
        return post.getId();
    }
    //
    public String findbyId(Post post){
       Post get = postRepository.findById(post.getId()).get();
       return get.getTitle();
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
    public List<Post> findPosts(){
        List<Post> result = postRepository.findAll();
        return result;
    }
}
