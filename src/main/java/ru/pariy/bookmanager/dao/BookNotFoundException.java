package ru.pariy.bookmanager.dao;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message, long id, Exception cause) {
        super(String.format("%s id=%d", message, id)); // Add Cause From Spring native exception
    }
}
