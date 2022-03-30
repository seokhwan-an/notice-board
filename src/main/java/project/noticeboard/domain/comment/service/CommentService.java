package project.noticeboard.domain.comment.service;

import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.comment.repository.CommentRepository;

import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;
    //DI 가능하게
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Long save(Comment comment){
        commentRepository.save(comment);
        return comment.getId();
    }

    public List<Comment> findComments(){
        List<Comment> result = commentRepository.findAll();
        return result;
    }

    public void delete(Long id){
        commentRepository.delete(id);
    }
}
