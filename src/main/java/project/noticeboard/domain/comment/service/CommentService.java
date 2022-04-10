package project.noticeboard.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.comment.repository.CommentRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    //DI 가능하게


    public Long save(Comment comment){
        commentRepository.save(comment);
        return comment.getId();
    }
    public Optional<Comment> findbyId(Long id){
        Optional<Comment> get = Optional.ofNullable(commentRepository.findById(id)).get();
        return get;
    }

    public List<Comment> findComments(){
        List<Comment> result = commentRepository.findAll();
        return result;
    }

    @Transactional
    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
