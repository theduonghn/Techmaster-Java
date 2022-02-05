package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class MovieList {
    UUID userId;
    String name;
    List<Movie> movies;

    public MovieList(UUID userId, String name) {
        this.userId = userId;
        this.name = name;
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MovieList(" + "name=" + name + ", " + movies.size() + " movies" + ')';
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
}
