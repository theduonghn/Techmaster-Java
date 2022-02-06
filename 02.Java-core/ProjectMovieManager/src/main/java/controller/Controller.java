package controller;

import model.*;
import service.MovieListService;
import service.MovieService;
import service.UserService;
import util.Util;
import util.Validate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    UserService userService = new UserService();
    MovieService movieService = new MovieService();
    MovieListService movieListService = new MovieListService();

    List<User> allUsers = userService.initUsers();
    List<Movie> allMovies = movieService.initMovies();
    List<Rating> allRatings = new ArrayList<>();

    boolean continueProgram = true;

    public void run() {
        menu();
    }

    public void menu() {
        while (continueProgram) {
            try {
                System.out.println("----------QUẢN LÝ PHIM----------");
                System.out.println("1. Đăng nhập");
                System.out.println("2. Đăng kí");
                System.out.println("0. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> login();
                    case 2 -> register();
                    case 0 -> continueProgram = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void login() {
        boolean continueLoop = true;
        while (continueLoop) {
            User user = userService.login(allUsers);
            if (user != null) { // Đăng nhập thành công
                loginSuccess(user);
            } else { // Sai mật khẩu
                loginFail();
            }
            continueLoop = false;
        }
    }

    public void register() {
        userService.register(allUsers);
    }

    public void loginSuccess(User user) {
        if (user.getRole().equals(UserRole.ADMIN)) {
            menuAdmin(user);
        } else if (user.getRole().equals(UserRole.USER)) {
            menuUser(user);
        }
    }

    public void loginFail() {
        System.out.println("Đăng nhập thất bại");
    }

    public void menuAdmin(User user) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------MENU----------");
                System.out.println("Chào mừng " + user.getEmail());
                System.out.println("1. Tìm phim");
                System.out.println("2. Thêm phim mới");
                System.out.println("3. Đổi mật khẩu");
                System.out.println("0. Đăng xuất");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> menuSearchMovie(user);
                    case 2 -> addMovie();
                    case 3 -> changePassword(user);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void changePassword(User user) {
        System.out.print("Nhập mật khẩu mới: ");
        String password = Util.sc.nextLine();
        userService.updatePassword(user, password);
    }

    public void menuUser(User user) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------MENU----------");
                System.out.println("Chào mừng " + user.getEmail());
                System.out.println("1. Tìm phim");
                System.out.println("2. Xem danh sách phim");
                System.out.println("3. Tạo danh sách phim");
                System.out.println("4. Đổi mật khẩu");
                System.out.println("0. Đăng xuất");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> menuSearchMovie(user);
                    case 2 -> {
                        MovieList movieList = selectMovieList(user);
                        if (movieList != null) {
                            menuSelectMovieList(user, movieList);
                        }
                    }
                    case 3 -> movieListService.inputMovieList(user);
                    case 4 -> changePassword(user);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void menuSelectMovieList(User user, MovieList movieList) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------DANH SÁCH PHIM----------");
                System.out.println(
                        "Danh sách đang chọn: " + movieList.getName() + ", " + movieList.getMovies().size() + " phim");
                System.out.println("1. Phim trong danh sách");
                System.out.println("2. Thêm phim vào danh sách");
                System.out.println("3. Xoá phim khỏi danh sách");
                System.out.println("4. Đổi tên danh sách");
                System.out.println("5. Xoá danh sách");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1:
                        if (movieList.getMovies().size() == 0) {
                            System.out.println("Danh sách phim trống");
                        } else {
                            movieService.showMoviesWithRatings(movieList.getMovies(), user, allRatings);
                        }
                        break;
                    case 2:
                        menuSearchMovieAddToMovieList(user, movieList);
                        break;
                    case 3:
                        menuDeleteMovieFromMovieList(movieList);
                        break;
                    case 4:
                        movieListService.changeMovieListName(user.getMovieLists(), movieList);
                        break;
                    case 5:
                        movieListService.removeMovieList(user.getMovieLists(), movieList);
                        continueLoop = false;
                        break;
                    case 0:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void menuDeleteMovieFromMovieList(MovieList movieList) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------CHỌN DANH SÁCH PHIM----------");
                if (movieList.getMovies().size() == 0) {
                    System.out.println("Danh sách phim trống");
                } else {
                    Util.showAllWithRowNumber(movieList.getMovies());
                }
                System.out.println("0. Trở về");
                System.out.print("Chọn danh sách: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    Movie movie = Util.selectItemByRowNumber(movieList.getMovies(), choice);
                    movieListService.removeMovieFromMovieList(movieList, movie);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private MovieList selectMovieList(User user) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------CHỌN DANH SÁCH PHIM----------");
                if (user.getMovieLists().size() == 0) {
                    System.out.println("Bạn chưa có danh sách phim nào");
                } else {
                    Util.showAllWithRowNumber(user.getMovieLists());
                }
                System.out.println("0. Trở về");
                System.out.print("Chọn danh sách: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    // Return selected movieList
                    return Util.selectItemByRowNumber(user.getMovieLists(), choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
        return null;
    }

    public void menuSearchMovie(User user) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------TÌM PHIM----------");
                System.out.println("1. Tất cả phim");
                System.out.println("2. Tìm theo tên");
                System.out.println("3. Tìm theo năm phát hành");
                System.out.println("4. Tìm theo thể loại");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> findAllMovies(user);
                    case 2 -> searchMoviesByTitle(user);
                    case 3 -> searchMoviesByYear(user);
                    case 4 -> searchMoviesByCategory(user);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void menuSearchMovieAddToMovieList(User user, MovieList movieList) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------TÌM PHIM----------");
                System.out.println("1. Tất cả phim");
                System.out.println("2. Tìm theo tên");
                System.out.println("3. Tìm theo năm phát hành");
                System.out.println("4. Tìm theo thể loại");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> findAllMoviesAddToMovieList(user, movieList);
                    case 2 -> searchMoviesByTitleAddToMovieList(user, movieList);
                    case 3 -> searchMoviesByYearAddToMovieList(user, movieList);
                    case 4 -> searchMoviesByCategoryAddToMovieList(user, movieList);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void addMovie() {
        movieService.inputMovie(allMovies);
    }

    public void findAllMovies(User user) {
        Movie selectedMovie = selectMovieAll(user);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    private void findAllMoviesAddToMovieList(User user, MovieList movieList) {
        while (true) {
            Movie selectedMovie = selectMovieAll(user);
            if (selectedMovie == null) {
                break;
            }
            movieListService.addMovieToMovieList(movieList, selectedMovie);
        }
    }

    private Movie selectMovieAll(User user) {
        return selectMovie(user, allMovies);
    }

    private Movie selectMovieFromList(User user, List<Movie> movies) {
        return selectMovie(user, movies);
    }

    public void searchMoviesByTitle(User user) {
        System.out.print("Nhập từ khoá tên phim: ");
        String title = Util.sc.nextLine();
        List<Movie> movies = movieService.getMoviesByTitle(allMovies, title);
        Movie selectedMovie = selectMovieFromList(user, movies);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    private void searchMoviesByTitleAddToMovieList(User user, MovieList movieList) {
        System.out.print("Nhập từ khoá tên phim: ");
        String title = Util.sc.nextLine();
        List<Movie> movies = movieService.getMoviesByTitle(allMovies, title);
        while (true) {
            Movie selectedMovie = selectMovieFromList(user, movies);
            if (selectedMovie == null) {
                break;
            }
            movieListService.addMovieToMovieList(movieList, selectedMovie);
        }
    }

    public void searchMoviesByYear(User user) {
        System.out.print("Nhập năm phát hành: ");
        int year = Util.inputInt();
        List<Movie> movies = movieService.getMoviesByYear(allMovies, year);
        Movie selectedMovie = selectMovieFromList(user, movies);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    private void searchMoviesByYearAddToMovieList(User user, MovieList movieList) {
        System.out.print("Nhập năm phát hành: ");
        int year = Util.inputInt();
        List<Movie> movies = movieService.getMoviesByYear(allMovies, year);
        while (true) {
            Movie selectedMovie = selectMovieFromList(user, movies);
            if (selectedMovie == null) {
                break;
            }
            movieListService.addMovieToMovieList(movieList, selectedMovie);
        }
    }

    public void searchMoviesByCategory(User user) {
        System.out.print("Nhập thể loại: ");
        String category = Util.sc.nextLine();
        List<Movie> movies = movieService.getMoviesByCategory(allMovies, category);
        Movie selectedMovie = selectMovieFromList(user, movies);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    private void searchMoviesByCategoryAddToMovieList(User user, MovieList movieList) {
        System.out.print("Nhập thể loại: ");
        String category = Util.sc.nextLine();
        List<Movie> movies = movieService.getMoviesByCategory(allMovies, category);
        while (true) {
            Movie selectedMovie = selectMovieFromList(user, movies);
            if (selectedMovie == null) {
                break;
            }
            movieListService.addMovieToMovieList(movieList, selectedMovie);
        }
    }

    public Movie selectMovie(User user, List<Movie> movies) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                if (user.getRole().equals(UserRole.ADMIN)) {
                    Util.showAllWithRowNumber(movies);
                } else if (user.getRole().equals(UserRole.USER)) {
                    movieService.showMoviesWithRatingsAndMovieLists(movies, user, allRatings);
                }
                System.out.println("0. Trở về");
                System.out.print("Chọn phim: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    // Return selected movie
                    return Util.selectItemByRowNumber(movies, choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
        return null;
    }

    public void selectMovieSuccess(User user, Movie movie) {
        if (user.getRole().equals(UserRole.ADMIN)) {
            menuSelectMovieAdmin(movie);
        } else if (user.getRole().equals(UserRole.USER)) {
            menuSelectMovieUser(user, movie);
        }
    }

    public void menuSelectMovieAdmin(Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------TUỲ CHỌN PHIM----------");
                System.out.println("Phim đang chọn: " + movie.getTitle());
                System.out.println("1. Cập nhật thông tin phim");
                System.out.println("2. Xoá phim");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> menuUpdateMovie(movie);
                    case 2 -> {
                        deleteMovie(movie);
                        continueLoop = false;
                    }
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public void deleteMovie(Movie movie) {
        movieService.deleteMovie(allMovies, movie);
        System.out.println("Xoá phim thành công");
    }

    public void menuUpdateMovie(Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------CẬP NHẬT THÔNG TIN PHIM----------");
                System.out.println("Phim đang chọn: " + movie.getTitle());
                System.out.println("1. Cập nhật tên");
                System.out.println("2. Cập nhật năm phát hành");
                System.out.println("3. Cập nhật độ dài");
                System.out.println("4. Thêm thể loại");
                System.out.println("5. Xoá thể loại");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> updateMovieTitle(movie);
                    case 2 -> updateMovieYear(movie);
                    case 3 -> updateMovieLength(movie);
                    case 4 -> addCategory(movie);
                    case 5 -> removeCategory(movie);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void removeCategory(Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                Util.showAllWithRowNumber(movie.getCategories());
                System.out.println("0. Trở về");
                System.out.print("Chọn thể loại muốn xoá: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    String category = Util.selectItemByRowNumber(movie.getCategories(), choice);
                    movieService.removeCategory(movie, category);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void addCategory(Movie movie) {
        System.out.print("Nhập thể loại: ");
        String category = Util.sc.nextLine();
        movieService.addCategory(movie, category);
    }

    private void updateMovieLength(Movie movie) {
        System.out.print("Nhập độ dài mới: ");
        int length = Util.inputInt();
        movieService.updateMovieLength(movie, length);
        System.out.println("Cập nhật thông tin phim thành công");
    }

    private void updateMovieYear(Movie movie) {
        System.out.print("Nhập năm phát hành mới: ");
        int year = Util.inputInt();
        movieService.updateMovieYear(movie, year);
        System.out.println("Cập nhật thông tin phim thành công");
    }

    private void updateMovieTitle(Movie movie) {
        System.out.print("Nhập tên mới: ");
        String title = Util.sc.nextLine();
        movieService.updateMovieTitle(movie, title);
        System.out.println("Cập nhật thông tin phim thành công");
    }

    private void menuSelectMovieUser(User user, Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------TUỲ CHỌN PHIM----------");
                System.out.println("Phim đang chọn: " + movie.getTitle());
                System.out.println("1. Đánh giá phim");
                System.out.println("2. Thêm vào danh sách");
                System.out.println("3. Xoá khỏi danh sách");
                System.out.println("0. Trở về");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Util.inputInt();
                switch (choice) {
                    case 1 -> rateMovie(user, movie);
                    case 2 -> menuAddMovieToMovieList(user, movie);
                    case 3 -> menuRemoveMovieFromMovieList(user, movie);
                    case 0 -> continueLoop = false;
                    default -> System.out.println("Không có lựa chọn này");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void menuAddMovieToMovieList(User user, Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------THÊM PHIM VÀO DANH SÁCH----------");
                System.out.println("Phim đang chọn: " + movie.getTitle());
                movieListService.showMovieLists(user.getMovieLists(), movie);
                System.out.println("0. Trở về");
                System.out.print("Chọn danh sách: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    MovieList movieList = Util.selectItemByRowNumber(user.getMovieLists(), choice);
                    movieListService.addMovieToMovieList(movieList, movie);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void menuRemoveMovieFromMovieList(User user, Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("----------XOÁ PHIM KHỎI DANH SÁCH----------");
                System.out.println("Phim đang chọn: " + movie.getTitle());
                List<MovieList> movieListContainsMovie =
                        movieListService.getMovieListsByMovieId(user.getMovieLists(), movie.getId());
                movieListService.showMovieLists(movieListContainsMovie, movie);
                System.out.println("0. Trở về");
                System.out.print("Chọn danh sách: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    MovieList movieList = Util.selectItemByRowNumber(movieListContainsMovie, choice);
                    movieListService.removeMovieFromMovieList(movieList, movie);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private void rateMovie(User user, Movie movie) {
        while (true) {
            System.out.print("Nhập điểm đánh giá: ");
            int point = Util.inputInt();
            if (Validate.validateRatingPoint(point)) {
                Rating rating = new Rating(user.getId(), movie.getId(), point);
                allRatings.add(rating);
                break;
            } else {
                System.out.println("Điểm đánh giá phải từ 1 đến 10");
            }
        }
    }
}
