package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Movie;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovieList {
    UUID userId;
    String name;
    List<Movie> movies;
}
