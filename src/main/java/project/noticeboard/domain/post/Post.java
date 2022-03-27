package project.noticeboard.domain.post;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.noticeboard.domain.Timestamped;

import javax.persistence.*;
import java.util.List;

@Entity //jpa가 관리하는 entity
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


}
