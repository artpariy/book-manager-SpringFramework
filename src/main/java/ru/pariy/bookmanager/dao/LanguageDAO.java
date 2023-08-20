package ru.pariy.bookmanager.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pariy.bookmanager.model.Language;

import java.util.List;

@Component
public class LanguageDAO {
    JdbcTemplate jdbcTemplate;

    public LanguageDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Language> languageList() {
        final String SQL_QUERY = "SELECT * FROM language";
        return jdbcTemplate.query(SQL_QUERY, new BeanPropertyRowMapper<>(Language.class));
    }
}
