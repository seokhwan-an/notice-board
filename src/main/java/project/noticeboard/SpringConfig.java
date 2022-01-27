package project.noticeboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.noticeboard.repository.MemoryPostRepository;
import project.noticeboard.repository.PostRepository;
import project.noticeboard.service.PostService;

@Configuration
public class SpringConfig {

    @Bean
    public PostService postService(){
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new MemoryPostRepository();
    }
}
