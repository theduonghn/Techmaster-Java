package service;

import model.Movie;
import model.Rating;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class RatingService {
    public List<Rating> getRatingsByUser(List<Rating> ratings, User user) {
        List<Rating> results = new ArrayList<>();
        for (Rating rating : ratings) {
            if (rating.getUserId().equals(user.getId())) {
                results.add(rating);
            }
        }
        return results;
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
