package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String author;
    private String startDayWrite;

    public Blog() {
    }

    public Blog(int id, String title, String content, String author, String startDayWrite) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.startDayWrite = startDayWrite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStartDayWrite() {
        return startDayWrite;
    }

    public void setStartDayWrite(String startDayWrite) {
        this.startDayWrite = startDayWrite;
    }
}
