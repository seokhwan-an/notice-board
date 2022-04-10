package project.noticeboard.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.comment.service.CommentService;
import project.noticeboard.domain.post.Post;
import project.noticeboard.domain.post.service.PostService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

@Slf4j
@RequestMapping("/board/posts")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    @GetMapping(value = "/{no}/new-comment")
    public String CreateForm(){
        return "comments/createCommentForm";
    }

    //댓글 생성
    @PostMapping(value = "/{no}/new-comment")
    public String create(CommentForm commentForm,@PathVariable("no") Long no, @RequestParam("type") String type) throws UnsupportedEncodingException {
        type= URLEncoder.encode(type, "UTF-8");
        String num = no.toString();
        Comment comment = new Comment();
        Optional<Post> post = postService.findbyId(no);
        post.ifPresent(value -> comment.setPost(value));
        comment.setContent(commentForm.getBody());
        commentService.save(comment);
        return "redirect:/board/posts/"+num+"?type="+type;
    }

}
