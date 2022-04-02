package project.noticeboard.domain.board;

import lombok.Getter;
import lombok.Setter;
import project.noticeboard.domain.post.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    @OneToMany(mappedBy = "board")
    List<Post> posts = new ArrayList<>();
}
