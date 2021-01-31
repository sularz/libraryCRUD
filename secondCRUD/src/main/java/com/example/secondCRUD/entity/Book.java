package com.example.secondCRUD.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 128, nullable = false)
    private String title;

    private float price;

    @ManyToOne //many books to one author
    @JoinColumn(name = "author_id")
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
