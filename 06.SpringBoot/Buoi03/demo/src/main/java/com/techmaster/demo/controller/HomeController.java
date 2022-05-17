package com.techmaster.demo.controller;

import com.techmaster.demo.model.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("name", "Duong");
        model.addAttribute("age", 25);
        model.addAttribute("book", new Book("De men phieu luu ky", "To Hoai"));
        model.addAttribute("message", "<h1>Hello <span style='color:red'>world<span/></h1>");
        return "index";
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

    @GetMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public Book returnBook() {
        return new Book("De men phieu luu ky", "To Hoai");
    }
}
