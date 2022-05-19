package com.techmaster.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String id;
    private String title;
    private String author;
}
