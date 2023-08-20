package ru.pariy.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pariy.bookmanager.dao.LanguageDAO;
import ru.pariy.bookmanager.model.Language;

import java.util.List;

@Controller
public class LanguageController {
    private final LanguageDAO languageDAO;
    @Autowired
    public LanguageController(LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }

    @GetMapping("/language")
    @ResponseBody
    public List<Language> languageList() {
        return languageDAO.languageList();
    }
}
