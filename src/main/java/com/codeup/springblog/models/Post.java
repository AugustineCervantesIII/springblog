package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")//table name
public class Post {

    @Id //PRIMARY KEY annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENT annotation
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    public Post(){
    }

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String newBody){
        this.body = newBody;
    }

}
