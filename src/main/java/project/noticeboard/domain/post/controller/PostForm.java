package project.noticeboard.domain.post.controller;

public class PostForm {
    private String title;
    private String writer;
    private String body;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getWriter(){
        return writer;
    }
    public void setWriter(String writer){
        this.writer = writer;
    }

    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }
}
