package controller;

import model.*;
import service.MovieListService;
import service.MovieService;
import service.UserService;
import util.Util;

import java.util.List;

public class Controller {
    List<User> users;
    List<Movie> movies;
    List<Rating> ratings;

    UserService userService = new UserService();
    MovieService movieService = new MovieService();
    MovieListService movieListService = new MovieListService();

    boolean continueProgram = true;

    public void run() {
        users = userService.initUsers();
        movies = movieService.initMovies();
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
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 0:
                        continueProgram = false;
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

    public void login() {
        boolean continueLoop = true;
        while (continueLoop) {
            User user = userService.login(users);
            if (user != null) { // Đăng nhập thành công
                loginSuccess(user);
                continueLoop = false;
            } else { // Sai mật khẩu
                loginFail();
                continueLoop = false;
            }
        }
    }

    public void register() {
        userService.register(users);
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
                    case 1:
                        menuSearchMovie(user);
                        break;
                    case 2:
                        addMovie();
                        break;
                    case 3:
                        changePassword(user);
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
                    case 1:
                        menuSearchMovie(user);
                        break;
                    // TODO
                    case 2:
                        if (user.getMovieLists().size() == 0) {
                            System.out.println("Bạn chưa có danh sách phim nào");
                        } else {
                            Util.showAllWithRowNumber(user.getMovieLists());
                        }
                        break;
                    case 3:
                        movieListService.inputMovieList(user);
                        break;
                    case 4:
                        changePassword(user);
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
                    case 1:
                        findAllMovies(user);
                        break;
                    case 2:
                        searchMoviesByTitle(user);
                        break;
                    case 3:
                        searchMoviesByYear(user);
                        break;
                    case 4:
                        searchMoviesByCategory(user);
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

    public void addMovie() {
        movieService.inputMovie(movies);
    }

    // TODO: display rating if role is user
    // TODO: display movieList if role is user
    public void findAllMovies(User user) {
        Util.showAllWithRowNumber(movies);
        Movie selectedMovie = selectMovie(movies);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    // TODO: display rating if role is user
    // TODO: display movieList if role is user
    public void searchMoviesByTitle(User user) {
        System.out.print("Nhập từ khoá tên phim: ");
        String title = Util.sc.nextLine();
        List<Movie> result = movieService.getMoviesByTitle(movies, title);
        Util.showAllWithRowNumber(result);
        Movie selectedMovie = selectMovie(result);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    // TODO: display rating if role is user
    // TODO: display movieList if role is user
    public void searchMoviesByYear(User user) {
        System.out.print("Nhập năm phát hành: ");
        int year = Util.inputInt();
        List<Movie> result = movieService.getMoviesByYear(movies, year);
        Util.showAllWithRowNumber(result);
        Movie selectedMovie = selectMovie(result);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    // TODO: display rating if role is user
    // TODO: display movieList if role is user
    public void searchMoviesByCategory(User user) {
        System.out.print("Nhập thể loại: ");
        String category = Util.sc.nextLine();
        List<Movie> result = movieService.getMoviesByCategory(movies, category);
        Util.showAllWithRowNumber(result);
        Movie selectedMovie = selectMovie(result);
        if (selectedMovie != null) {
            selectMovieSuccess(user, selectedMovie);
        }
    }

    public Movie selectMovie(List<Movie> searchedMovies) {
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                System.out.println("0. Trở về");
                System.out.print("Chọn phim: ");

                int choice = Util.inputInt();
                if (choice == 0) {
                    continueLoop = false;
                } else {
                    Movie selectedMovie = Util.selectItemByRowNumber(searchedMovies, choice);
                    return selectedMovie;
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
                    case 1:
                        menuUpdateMovie(movie);
                        break;
                    case 2:
                        deleteMovie(movie);
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

    public void deleteMovie(Movie movie) {
        movieService.deleteMovie(movies, movie);
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
                    case 1:
                        updateMovieTitle(movie);
                        break;
                    case 2:
                        updateMovieYear(movie);
                        break;
                    case 3:
                        updateMovieLength(movie);
                        break;
                    case 4:
                        addCategory(movie);
                        break;
                    case 5:
                        removeCategory(movie);
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
                    case 1:
                        rateMovie(user, movie);
                        break;
                    case 2:
                        menuAddMovieToMovieList(user, movie);
                        break;
                    case 3:
                        menuRemoveMovieFromMovieList(user, movie);
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
        System.out.print("Nhập điểm đánh giá: ");
        int point = Util.inputInt();
        Rating rating = new Rating(user.getId(), movie.getId(), point);
        ratings.add(rating);
    }
}
