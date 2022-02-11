package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MovieList {
    String name;
    List<Movie> movies;

    public MovieList(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " (" + movies.size() + " movies)";
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
}
