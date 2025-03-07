package com.example.test.modules.book.model;

import java.util.Date;

public class Book {
    private long id;
    private String title;
    private String synopsis;
    private Date publicationDate;
    private String authors;
    private String publishers;
    private int totalStock;
    private int currentStock;

    public Book(long id, String title, String synopsis, Date publicationDate, String authors, String publishers, int totalStock, int currentStock) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.publicationDate = publicationDate;
        this.authors = authors;
        this.publishers = publishers;
        this.totalStock = totalStock;
        this.currentStock = currentStock;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}