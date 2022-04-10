package project.noticeboard.domain.comment.controller;

public class CommentForm {
    private String content;

    public String getBody(){
        return content;
    }
    public void setBody(String body){
        this.content = body;
    }
}
