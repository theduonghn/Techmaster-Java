package service;

import model.Movie;
import model.MovieList;
import model.Rating;
import model.User;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MovieService {
    MovieListService movieListService = new MovieListService();
    RatingService ratingService = new RatingService();

    public List<Movie> initMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie("The Shawshank Redemption", 1994, 142, new ArrayList<>());
        m1.addCategory("Drama");
        movies.add(m1);

        Movie m2 = new Movie("The Godfather", 1972, 175, new ArrayList<>());
        m2.addCategory("Crime");
        m2.addCategory("Drama");
        movies.add(m2);

        Movie m3 = new Movie("The Godfather: Part II", 1974, 202, new ArrayList<>());
        m3.addCategory("Crime");
        m3.addCategory("Drama");
        movies.add(m3);

        Movie m4 = new Movie("The Dark Knight", 2008, 152, new ArrayList<>());
        m4.addCategory("Action");
        m4.addCategory("Crime");
        m4.addCategory("Drama");
        movies.add(m4);

        Movie m5 = new Movie("12 Angry Men", 1957, 96, new ArrayList<>());
        m5.addCategory("Crime");
        m5.addCategory("Drama");
        movies.add(m5);

        Movie m6 = new Movie("Schindler's List", 1993, 195, new ArrayList<>());
        m6.addCategory("Biography");
        m6.addCategory("Drama");
        m6.addCategory("History");
        movies.add(m6);

        Movie m7 = new Movie("The Lord of the Rings: The Return of the King", 2003, 201, new ArrayList<>());
        m7.addCategory("Action");
        m7.addCategory("Adventure");
        m7.addCategory("Drama");
        movies.add(m7);

        Movie m8 = new Movie("Pulp Fiction", 1994, 154, new ArrayList<>());
        m8.addCategory("Crime");
        m8.addCategory("Drama");
        movies.add(m8);

        Movie m9 = new Movie("The Good, the Bad and the Ugly", 1966, 178, new ArrayList<>());
        m9.addCategory("Adventure");
        m9.addCategory("Western");
        movies.add(m9);

        Movie m10 = new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, 178, new ArrayList<>());
        m10.addCategory("Action");
        m10.addCategory("Adventure");
        m10.addCategory("Drama");
        movies.add(m10);

        return movies;
    }

    public void inputMovie(List<Movie> movies) {
        System.out.print("Nhập tên phim: ");
        String title = Util.sc.nextLine();
        System.out.print("Nhập năm phát hành: ");
        int year = Util.inputInt();
        System.out.print("Nhập độ dài: ");
        int length = Util.inputInt();
        System.out.print("Thêm các thể loại (cách nhau bởi dấu phẩy): ");
        String[] categoriesArray = Util.sc.nextLine().split("\s*,\s*");
        List<String> categories = new ArrayList<>();
        for (String category : categoriesArray) {
            // Remove empty string if it is in list
            if (!category.equals("")) {
                categories.add(category);
            }
        }
        Movie movie = new Movie(title, year, length, categories);
        movies.add(movie);
        System.out.println("Thêm phim thành công");
        System.out.println(movie);
    }

    public Movie getMovieById(List<Movie> movies, UUID id) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByTitle(List<Movie> movies, String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> getMoviesByYear(List<Movie> movies, int year) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear() == year) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> getMoviesByCategory(List<Movie> movies, String category) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            List<String> categories = movie.getCategories();
            for (String c : categories) {
                if (c.equalsIgnoreCase(category)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public void deleteMovie(List<Movie> movies, Movie movie) {
        movies.remove(movie);
    }

    public void updateMovieTitle(Movie movie, String title) {
        movie.setTitle(title);
    }

    public void updateMovieYear(Movie movie, int year) {
        movie.setYear(year);
    }

    public void updateMovieLength(Movie movie, int length) {
        movie.setLength(length);
    }

    public void addCategory(Movie movie, String category) {
        movie.addCategory(category);
    }

    public void removeCategory(Movie movie, String category) {
        movie.removeCategory(category);
    }

    public void showMoviesWithRatings(List<Movie> movies, User user, List<Rating> ratings) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + 1 + ". " + movies.get(i));
            Rating rating = ratingService.getRatingByMovieAndUser(ratings, movies.get(i), user);
            if (rating != null) {
                System.out.println("Đánh giá của bạn: " + rating.getPoint());
            } else {
                System.out.println("Đánh giá của bạn: Chưa đánh giá");
            }
        }
    }

    public void showMoviesWithRatingAndMovieLists(List<Movie> movies, User user, List<Rating> ratings) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + 1 + ". " + movies.get(i));
            Rating rating = ratingService.getRatingByMovieAndUser(ratings, movies.get(i), user);
            if (rating != null) {
                System.out.println("Đánh giá của bạn: " + rating.getPoint());
            } else {
                System.out.println("Đánh giá của bạn: Chưa đánh giá");
            }
            List<MovieList> movieLists = movieListService.getMovieListsByMovie(user.getMovieLists(), movies.get(i));
            movieListService.showMovieListsInOneRow(movieLists);
        }
    }

    public void showMovieWithRatingAndMovieLists(Movie movie, User user, List<Rating> ratings) {
        System.out.println(movie);
        Rating rating = ratingService.getRatingByMovieAndUser(ratings, movie, user);
        if (rating != null) {
            System.out.println("Đánh giá của bạn: " + rating.getPoint());
        } else {
            System.out.println("Đánh giá của bạn: Chưa đánh giá");
        }
        List<MovieList> movieLists = movieListService.getMovieListsByMovie(user.getMovieLists(), movie);
        movieListService.showMovieListsInOneRow(movieLists);
    }
}
