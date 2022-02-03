package project.noticeboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.noticeboard.repository.JpaPostRepository;
import project.noticeboard.repository.MemoryPostRepository;
import project.noticeboard.repository.PostRepository;
import project.noticeboard.service.PostService;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public PostService postService(){
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new JpaPostRepository(em);
    }
}
