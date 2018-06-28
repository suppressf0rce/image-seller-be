package model;

import java.util.Date;

public class Comment extends Entity{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private User commenter;
    private User commentTo;
    private String content;
    private Date date;

    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//
    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public User getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(User commentTo) {
        this.commentTo = commentTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
