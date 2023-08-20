package ru.pariy.bookmanager.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pariy.bookmanager.model.Book;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {

    private static final Logger logger = LoggerFactory.getLogger(BookDAO.class);

    private final JdbcTemplate jdbcTemplate;
    private BookNotFoundException bookNotFoundException;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        final String SQL_QUERY = "SELECT books.id AS id, books.name AS name, author, publishers.name AS publisher, country.name AS country,\n" +
                "language.name AS language, publication_date, isbn, price\n" +
                "FROM books\n" +
                "JOIN publishers ON publishers.id = books.publisher_id\n" +
                "JOIN country ON country.id = books.country_id\n" +
                "JOIN language ON language.id = books.language_id\n" +
                "ORDER BY author";
        List<Book> bookList;
        bookList = jdbcTemplate.query(SQL_QUERY, new BookMapper());
        logger.info("Book list successfully gotten");
        return bookList;
    }

    public Book show(long id) {
        Book book;
        try {
            final String SQL_QUERY = "SELECT books.id AS id, books.name AS name, author, publishers.name AS publisher, country.name AS country,\n" +
                    "language.name AS language, publication_date, isbn, price\n" +
                    "FROM books\n" +
                    "JOIN publishers ON publishers.id = books.publisher_id\n" +
                    "JOIN country ON country.id = books.country_id\n" +
                    "JOIN language ON language.id = books.language_id\n" +
                    "WHERE books.id = ?";
            book = jdbcTemplate.queryForObject(SQL_QUERY, new BookMapper(), id);
        } catch (Exception exception) {
            throw new BookNotFoundException("Book not found, with", id, exception);
        }
        logger.info("Book successfully gotten. Book detail: {}", book);
        return book;
    }

    public void save(Book book) {
        final String SQL_UPDATE = "INSERT INTO books (name, author, publisher_id, country_id, language_id," +
                " publication_date, isbn, price)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL_UPDATE, book.getName(), book.getAuthor(),
                book.getPublisherId(), book.getCountryId(), book.getLanguageId(), Date.valueOf(book.getPublicationDate()), book.getIsbn(), book.getPrice());
        logger.info("Book successfully saved to db. Book details: {}", book);
    }

    public void update(long id, Book updatedBook) {
        final String SQL_UPDATE = "UPDATE books SET name=?, author=?," +
                " publisher_id=?, country_id=?, language_id=?, publication_date=?, isbn=?, price=? WHERE id=?";
        jdbcTemplate.update(SQL_UPDATE, updatedBook.getName(), updatedBook.getAuthor(),
                updatedBook.getPublisherId(), updatedBook.getCountryId(), updatedBook.getLanguageId(), Date.valueOf(updatedBook.getPublicationDate()),
                updatedBook.getIsbn(), updatedBook.getPrice(), id);
        logger.info("Book successfully updated. Book details: {}", updatedBook);
    }

    public void delete(long id) {
        final String SQL_UPDATE = "DELETE FROM books WHERE id=?";
        jdbcTemplate.update(SQL_UPDATE, id);
        logger.info("Book successfully. Remote book id:{}", id);
    }
}
