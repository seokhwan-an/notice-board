package project.noticeboard.domain.post;

import lombok.Getter;
import lombok.Setter;
import project.noticeboard.domain.Timestamped;
import project.noticeboard.domain.board.Board;
import project.noticeboard.domain.comment.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="post") //jpa가 관리하는 entity
@Getter @Setter
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 스스로 생성해주는 것은 IDENTITY라고 함
    private Long id;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private String writer;

    @Column
    private Long favorite;

    @Column
    private Long unlike;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();
}
