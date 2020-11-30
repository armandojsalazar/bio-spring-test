package com.codeup.blog.models;


public class Post {
    private String title;
    private String body;
    private long id;
    private String author;


    public Post(String title, String body, long id, String author){
        this.title = title;
        this.body = body;
        this.id = id;
        this.author = author;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
