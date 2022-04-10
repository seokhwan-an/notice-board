package project.noticeboard.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.comment.service.CommentService;
import project.noticeboard.domain.post.Post;
import project.noticeboard.domain.post.controller.PostForm;
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
    //댓글 삭제
    @PostMapping (value = "/{no1}/comment/delete/{no2}")
    public String delete(@PathVariable("no1") Long no1, @PathVariable("no2") Long no2, @RequestParam("type") String type) throws UnsupportedEncodingException {
        type= URLEncoder.encode(type, "UTF-8");
        String num = no1.toString();
        commentService.delete(no2);
        return "redirect:/board/posts/"+num+"?type="+type;
    }
    @GetMapping(value = "/{no1}/comment/edit/{no2}")
    public String editForm(@PathVariable("no2") Long no2, Model model){
        Optional<Comment> comment = commentService.findbyId(no2);
        comment.ifPresent(value -> model.addAttribute("comment",value));
        return "comments/edit";
    }

    @PostMapping(value ="/{no1}/comment/edit/{no2}")
    public String edit(@PathVariable("no1") Long no1,@PathVariable("no2") Long no2, @RequestParam String type, CommentForm commentForm) throws UnsupportedEncodingException {
        Optional<Comment> comment = commentService.findbyId(no2);
        Comment edit_comment = comment.get();
        edit_comment.setContent(commentForm.getBody());
        commentService.save(edit_comment);
        type= URLEncoder.encode(type, "UTF-8");
        String num = no1.toString();
        return "redirect:/board/posts/"+num+"?type="+type;
    }
}
