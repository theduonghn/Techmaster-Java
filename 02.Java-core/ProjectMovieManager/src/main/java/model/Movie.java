package model;

import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Movie {
    private UUID id;
    private String title;
    private int year;
    private int length; // minutes
    private List<String> categories;

    public Movie(String title, int year, int length, List<String> categories) {
        this.id = Util.generateId();
        this.title = title;
        this.year = year;
        this.length = length;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie(" + "title='" + title + '\'' + ", year=" + year + ", length=" + length + ", categories=" +
                categories + ')';
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    public void removeCategory(String category) {
        this.categories.remove(category);
    }
}
