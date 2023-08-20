package ru.pariy.bookmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pariy.bookmanager.model.Publisher;

import java.util.List;
@Component
public class PublisherDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PublisherDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Publisher> getPublishers() {
        final String SQL_QUERY = "SELECT * FROM publishers";
        return jdbcTemplate.query(SQL_QUERY, new BeanPropertyRowMapper<>(Publisher.class));
    }
}
