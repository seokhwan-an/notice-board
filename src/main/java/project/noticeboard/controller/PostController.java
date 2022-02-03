package project.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.noticeboard.domain.Post;
import project.noticeboard.service.PostService;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping(value = "/posts/new")
    public String CreateForm(){
        return "posts/createPostForm";
    }

    // 게시글 데이터 저장
    @PostMapping(value = "/posts/new")
    public String create(PostForm postForm){
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setWriter(postForm.getWriter());
        post.setBody(postForm.getBody());
        postService.save(post);
        return "redirect:/";
    }
    //메인화면 조회
    @GetMapping("/")
    public String list(Model model){
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts",posts);
        return "home";
    }
    // 게시글 상세페이지
    @GetMapping("/posts/{no}")
    public String detail(@PathVariable("no") Long no, Model model){
        Optional<Post> post = postService.findbyId(no);
        post.ifPresent(value -> model.addAttribute("post",value));
        return "posts/detail";
    }
    // 게시글 삭제
    @PostMapping("/posts/{no}")
    public String delete(@PathVariable("no") Long no){
        postService.delete(no);
        return "redirect:/";
    }

    @GetMapping("/posts/edit/{no}")
    public String editform(@PathVariable("no") Long no, Model model){
        Optional<Post> post = postService.findbyId(no);
        post.ifPresent(value -> model.addAttribute("post",value));
        return "posts/edit";
    }
    // 게시글 수정하기
    @PostMapping("/posts/edit/{no}")
    public String edit(@PathVariable("no") Long no,PostForm postForm){
        Optional<Post> post = postService.findbyId(no);
        Post edit_post = post.get();
        edit_post.setTitle(postForm.getTitle());
        edit_post.setWriter(postForm.getWriter());
        edit_post.setBody(postForm.getBody());
        postService.save(edit_post);
        return "redirect:/posts/{no}";
    }
}
