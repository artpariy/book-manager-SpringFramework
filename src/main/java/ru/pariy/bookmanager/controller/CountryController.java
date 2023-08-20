package ru.pariy.bookmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pariy.bookmanager.dao.CountryDAO;
import ru.pariy.bookmanager.model.Country;

import java.util.List;

@Controller
public class CountryController {
    private final CountryDAO countryDAO;
    @Autowired
    public CountryController(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
    @GetMapping("/country")
    @ResponseBody
    public List<Country> countryData() {
        return countryDAO.getCountryList();
    }
}
