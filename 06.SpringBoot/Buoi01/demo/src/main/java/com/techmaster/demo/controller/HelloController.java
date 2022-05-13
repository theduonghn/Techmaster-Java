package com.techmaster.demo.controller;

import com.techmaster.demo.model.Book;
import com.techmaster.demo.model.Message;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World, Spring Boot!";
    }

    @RequestMapping("/hello/{yourName}")
    String helloName(@PathVariable("yourName") String yourName) {
        return "Hello World, Spring Boot! My name is " + yourName;
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book book() {
        return new Book("x111", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài");
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Book book_xml() {
        return new Book("x111", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài");
    }

    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable("a") int a, @PathVariable("b") int b) {
        return a + b;
    }

    @GetMapping("/name/{your_name}")
    public String hi(@PathVariable("your_name") String yourName) {
        return "Hi " + yourName;
    }

    @GetMapping("/add")
    public int add2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message echoMessage(@RequestBody Message message) {
        return message;
    }
}
