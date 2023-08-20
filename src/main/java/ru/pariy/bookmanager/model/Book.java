package ru.pariy.bookmanager.model;

import javax.validation.constraints.*;

public class Book {
    private long id;
    @NotEmpty(message = "Book name field should not empty")
    @Size(min = 2, max = 100, message = "Book name should be between 2 and 100 chars")
    private String name;
    @NotEmpty(message = "Book author field should not empty")
    @Size(min = 2, max = 60, message = "Book author should be between 2 and 60 chars")
    private String author;
    private String publisher;
    private int publisherId;
    private String country;
    private int countryId;
    private String language;
    private int languageId;
    @NotEmpty(message = "Book publication date field should not empty")
    private String publicationDate;
    @NotEmpty(message = "Book isbn code field should not empty")
    private String isbn;

    @PositiveOrZero(message = "Book price should be greater than 0")
    private double price;

    public Book() {

    }

    public Book(long id, String name, String author, String publisher, String country,
                String language, String publicationDate, String isbn, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.country = country;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
