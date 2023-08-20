package ru.pariy.bookmanager.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.pariy.bookmanager.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setPublisherId(0);
        book.setCountry(resultSet.getString("country"));
        book.setCountryId(0);
        book.setLanguage(resultSet.getString("language"));
        book.setLanguageId(0);
        book.setPublicationDate(resultSet.getDate("publication_date").toString());
        book.setIsbn(resultSet.getString("isbn"));
        book.setPrice(resultSet.getDouble("price"));
        return book;
    }
}
