package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class User {
    private UUID id;
    private String email;
    private String password;
    private UserRole role;
    private List<MovieList> movieLists;

    public User(String email, String password, UserRole role) {
        this.id = Util.generateId();
        this.email = email;
        this.password = password;
        this.role = role;
        this.movieLists = new ArrayList<>();
    }

    public void addMovieList(MovieList movieList) {
        this.movieLists.add(movieList);
    }

    public void removeMovieList(MovieList movieList) {
        this.movieLists.remove(movieList);
    }
}
