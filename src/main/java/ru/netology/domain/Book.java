package ru.netology.domain;

import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode (callSuper = true)
public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;

    public Book() {
    }

    public Book(int id, String name, int price, String author, int pages, int publishedYear) {
        super(id, name, price);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }


    @Override
    public boolean matches(String search) {
        return super.matches(search) || search.equals(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}

