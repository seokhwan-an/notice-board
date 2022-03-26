package project.noticeboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String content;

    @Column
    private String created_at;

    @Column
    private String update_at;

    @ManyToOne
    @JoinColumn(name = "postid")
    private Post post;
}
