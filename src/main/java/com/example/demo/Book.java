package com.example.demo;

import javax.persistence.Entity;

@Entity
public class Book extends Product{
    private String genre;
    private String author;
    private int publication;

    public Book() {

    }

    public Book(long id, String name, float price, String genre, String author, int publication) {
        super(id, name, price);
        this.genre = genre;
        this.author = author;
        this.publication = publication;
    }
}
