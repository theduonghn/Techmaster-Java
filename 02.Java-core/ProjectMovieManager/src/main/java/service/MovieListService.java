package service;

import model.Movie;
import model.MovieList;
import model.User;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MovieListService {
    UserService userService = new UserService();

    public void inputMovieList(User user) {
        System.out.print("Nhập tên danh sách: ");
        String name = Util.sc.nextLine();
        MovieList movieList = new MovieList(name);
        userService.addMovieList(user, movieList);
        System.out.println("Tạo danh sách thành công");
    }

    public boolean isMovieInMovieList(MovieList movieList, Movie movie) {
        return movieList.getMovies().contains(movie);
    }

    public boolean isMovieInAnyMovieList(List<MovieList> movieLists, Movie movie) {
        for (MovieList movieList : movieLists) {
            if (isMovieInMovieList(movieList, movie)) {
                return true;
            }
        }
        return false;
    }

    public void showMovieLists(List<MovieList> movieLists, Movie movie) {
        if (!isMovieInAnyMovieList(movieLists, movie)) {
            System.out.println("Phim này chưa có trong danh sách nào");
            return;
        }

        if (movieLists.size() == 0) {
            System.out.println("Bạn chưa có danh sách phim nào");
            return;
        }


        for (int i = 0; i < movieLists.size(); i++) {
            System.out.print(i + 1 + ". " + movieLists.get(i));
            if (isMovieInMovieList(movieLists.get(i), movie)) {
                System.out.println(": Phim đã có trong danh sách");
            } else {
                System.out.println();
            }
        }
    }

    public void addMovieToMovieList(MovieList movieList, Movie movie) {
        if (!movieList.getMovies().contains(movie)) {
            movieList.addMovie(movie);
            System.out.println("Thêm phim vào danh sách thành công");
        } else {
            System.out.println("Phim đã ở trong danh sách");
        }
    }

    public void removeMovieFromMovieList(MovieList movieList, Movie movie) {
        if (movieList.getMovies().contains(movie)) {
            movieList.removeMovie(movie);
            System.out.println("Xoá phim khỏi danh sách thành công");
        } else {
            System.out.println("Phim không có trong danh sách");
        }
    }

    public List<MovieList> getMovieListsByMovieId(List<MovieList> movieLists, UUID movieId) {
        List<MovieList> result = new ArrayList<>();
        for (MovieList movieList : movieLists) {
            List<Movie> movies = movieList.getMovies();
            for (Movie movie : movies) {
                if (movie.getId().equals(movieId)) {
                    result.add(movieList);
                    break;
                }
            }
        }
        return result;
    }

    public void updateMovieListName(MovieList movieList, String name) {
        movieList.setName(name);
        System.out.println("Cập nhật tên thành công");
    }

    public void deleteMovieList(List<MovieList> movieLists, MovieList movieList) {
        if (movieLists.remove(movieList)) {
            System.out.println("Xoá danh sách thành công");
        } else {
            System.out.println("Danh sách không tồn tại");
        }
    }

    public void changeMovieListName(List<MovieList> movieLists, MovieList movieList) {
        while (true) {
            System.out.print("Nhập tên mới: ");
            String name = Util.sc.nextLine();
            if (Validate.validateMovieListNameAvailable(movieLists, movieList, name)) {
                updateMovieListName(movieList, name);
                break;
            } else {
                System.out.println("Tên đã được sử dụng");
            }
        }
    }
}
