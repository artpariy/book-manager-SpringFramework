package ru.pariy.bookmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pariy.bookmanager.model.Country;

import java.util.List;

@Component
public class CountryDAO {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public CountryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> getCountryList() {
        final String SQL_QUERY = "SELECT * FROM country";
        return jdbcTemplate.query(SQL_QUERY, new BeanPropertyRowMapper<>(Country.class));
    }
}
