package project.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.noticeboard.domain.Post;
import project.noticeboard.service.PostService;

import java.util.List;

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
}
