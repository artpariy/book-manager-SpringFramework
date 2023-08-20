package ru.pariy.bookmanager.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.pariy.bookmanager.dao.BookDAO;
import ru.pariy.bookmanager.model.Book;


@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDAO bookDAO;
    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("bookList", bookDAO.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "book/new";
        bookDAO.save(book);
        return "redirect:/book";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("book", bookDAO.show(id));
        return "book/edit";
    }
    @PatchMapping("{id}")
    public String update(@ModelAttribute("book") Book book, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) return "book/edit";
        bookDAO.update(id, book);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        bookDAO.delete(id);
        return "redirect:/book";
    }

}
