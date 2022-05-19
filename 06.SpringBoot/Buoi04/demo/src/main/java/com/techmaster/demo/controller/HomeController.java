package com.techmaster.demo.controller;

import java.util.concurrent.ConcurrentHashMap;

import com.techmaster.demo.model.Book;
import com.techmaster.demo.repository.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/books")
    public String booksPage(Model model) {
        ConcurrentHashMap<String, Book> books = bookRepo.getBooks();
        model.addAttribute("books", books.values());
        return "books";
    }

    @GetMapping("/city")
    public String cityPage(Model model) {
        return "city";
    }

    @GetMapping("/text")
    public String textPage() {
        return "text";
    }

    @GetMapping("/query")
    public String query(Model model, @RequestParam("foo") String foo, @RequestParam("tom") String tom) {
        model.addAttribute("foo", foo);
        model.addAttribute("tom", tom);
        return "query";
    }

    @GetMapping("/add")
    public String query(Model model, @RequestParam("a") int a, @RequestParam("b") String b) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        return "add";
    }
}
