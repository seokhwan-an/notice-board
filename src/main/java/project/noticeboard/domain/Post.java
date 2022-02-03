package project.noticeboard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //jpa가 관리하는 entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 스스로 생성해주는 것은 IDENTITY라고 함
    private Long id;
    private String title;
    private String body;
    private String writer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
