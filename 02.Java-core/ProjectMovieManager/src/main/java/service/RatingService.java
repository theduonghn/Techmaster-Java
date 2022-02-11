package service;

import model.Movie;
import model.Rating;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RatingService {
    public List<Rating> getRatingsByUser(List<Rating> ratings, User user) {
        return ratings.stream().filter(rating -> rating.getUserId().equals(user.getId())).collect(Collectors.toList());
    }

    public Rating getRatingByMovieAndUser(List<Rating> ratings, Movie movie, User user) {
        for (Rating rating : getRatingsByUser(ratings, user)) {
            if (rating.getMovieId().equals(movie.getId())) {
                return rating;
            }
        }
        return null;
    }
}
