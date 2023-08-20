package ru.pariy.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pariy.bookmanager.dao.PublisherDAO;
import ru.pariy.bookmanager.model.Publisher;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherDAO publisherDAO;
    @Autowired
    public PublisherController(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }
    @GetMapping("/publisher")
    @ResponseBody
    public List<Publisher> publishersData() {
        return publisherDAO.getPublishers();
    }
}
