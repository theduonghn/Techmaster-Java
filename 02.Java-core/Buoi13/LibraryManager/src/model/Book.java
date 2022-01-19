package model;

import java.util.ArrayList;

public class Book {
    private int id;
    private String name;
    private ArrayList<String> categories;
    private String publishingCompany;

    public Book(int id, String name, ArrayList<String> categories, String publishingCompany) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.publishingCompany = publishingCompany;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + categories + " - " + publishingCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }
}
