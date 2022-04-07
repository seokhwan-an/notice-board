package project.noticeboard.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import project.noticeboard.domain.post.Post;
import project.noticeboard.domain.post.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Long save(Post post){
        postRepository.save(post);
        return post.getId();
    }
    //
    public Optional<Post> findbyId(Long id){
        Optional<Post> get = Optional.ofNullable(postRepository.findById(id)).get();
        return get;
    }
//     제목 검색 기능
//    public Optional<Post> findbyTitle(Post post){
//         Optional<Post> result = Optional.ofNullable(postRepository.findByTitle(post.getTitle()).get());
//         return result;
//    }
//
//     작성자 검색 기능
//    public Optional<Post> findbyWriter(Post post){
//        Optional<Post> result = Optional.ofNullable(postRepository.findByWriter(post.getWriter()).get());
//        return result;
//    }

//     모든 글 반환 기능
    public List<Post> findPosts(){
        List<Post> result = postRepository.findAll();
        return result;
    }
//     게시글 삭제
    public void delete(Long id){
        postRepository.deleteById(id);
    }
}
