package project.noticeboard.domain.comment;

import lombok.Getter;
import lombok.Setter;
import project.noticeboard.domain.Timestamped;
import project.noticeboard.domain.post.Post;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String content;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;
}
