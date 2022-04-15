package project.noticeboard.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.noticeboard.domain.board.Board;
import project.noticeboard.domain.board.service.BoardService;
import project.noticeboard.domain.comment.Comment;
import project.noticeboard.domain.comment.service.CommentService;
import project.noticeboard.domain.post.Post;
import project.noticeboard.domain.post.service.PostService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class PostController {

    private final PostService postService;
    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping(value = "/new-posts")
    public String CreateForm(){
        return "posts/createPostForm";
    }

    // 게시글 데이터 저장
    @PostMapping(value = "/new-posts")
    public String create(PostForm postForm, @RequestParam String type) throws UnsupportedEncodingException {
        Post post = new Post();
        Board board = boardService.findbyType(type);
        type= URLEncoder.encode(type, "UTF-8");
        post.setTitle(postForm.getTitle());
        post.setWriter(postForm.getWriter());
        post.setBody(postForm.getBody());
        post.setBoard(board);
        postService.save(post);
        return "redirect:/board?type="+ type;
    }
    // 게시글 조회
    @GetMapping()
    public String showAll(Model model, @RequestParam String type) {
        List<Post> posts = postService.findPosts();
        List<Post> filter = posts.stream()
                .filter(post -> post.getBoard().getType().equals(type))
                .collect(Collectors.toList());
        model.addAttribute("posts", filter);
        model.addAttribute("type", type);
        return "posts/posts";
    }
    // 게시글 상세페이지
    @GetMapping("/posts/{no}")
    public String detail(@PathVariable("no") Long no, @RequestParam String type, Model model){
        Optional<Post> post = postService.findbyId(no);
        List<Comment> comments = commentService.findComments();
        List<Comment> filter = comments.stream()
                .filter(comment -> comment.getPost().getId() == no)
                .collect(Collectors.toList());
        post.ifPresent(value -> model.addAttribute("post",value));
        model.addAttribute("comments",filter);
        model.addAttribute("type", type);
        return "posts/detail";
    }
    // 게시글 삭제
    @PostMapping("/posts/{no}")
    public String delete(@PathVariable("no") Long no, @RequestParam String type) throws UnsupportedEncodingException {
        postService.delete(no);
        type= URLEncoder.encode(type, "UTF-8");
        return "redirect:/board?type="+ type;
    }

    @GetMapping("/posts/edit/{no}")
    public String editform(@PathVariable("no") Long no, Model model){
        Optional<Post> post = postService.findbyId(no);
        post.ifPresent(value -> model.addAttribute("post",value));
        return "posts/edit";
    }
    // 게시글 수정하기
    @PostMapping("/posts/edit/{no}")
    public String edit(@PathVariable("no") Long no, @RequestParam String type, PostForm postForm) throws UnsupportedEncodingException {
        Optional<Post> post = postService.findbyId(no);
        Post edit_post = post.get();
        edit_post.setTitle(postForm.getTitle());
        edit_post.setWriter(postForm.getWriter());
        edit_post.setBody(postForm.getBody());
        postService.save(edit_post);
        type= URLEncoder.encode(type, "UTF-8");
        return "redirect:/board/posts/{no}?type=" + type;
    }
}
