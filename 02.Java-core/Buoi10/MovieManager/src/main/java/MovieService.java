import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class MovieService {
    public ArrayList<Movie> getAllMovies(String filePath) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            FileReader reader = new FileReader(filePath);

            Type type = new TypeToken<ArrayList<Movie>>() {
            }.getType();

            Gson gson = new Gson();

            movies = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        }
        return movies;
    }

    public void showAllMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void sortMoviesById(ArrayList<Movie> movies) {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getId() - o2.getId();
            }
        });
    }

    public void sortMoviesByYear(ArrayList<Movie> movies) {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear() - o2.getYear();
            }
        });
    }

    public void sortMoviesByTitle(ArrayList<Movie> movies) {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    public void sortMoviesByView(ArrayList<Movie> movies) {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.getView() > o2.getView()) {
                    return 1;
                } else if (o1.getView() < o2.getView()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void show3MoviesWithMostView(ArrayList<Movie> movies) {
        sortMoviesByView(movies); // Movies sorted by view, increasing
        Collections.reverse(movies); // Movies sorted by view, decreasing
        if (movies.size() <= 3) {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println(movies.get(i));
            }
        }
    }

    public void searchMoviesByTitle(ArrayList<Movie> movies, String searchTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println(movie);
            }
        }
    }

    public void searchMoviesByCategory(ArrayList<Movie> movies, String searchCategory) {
        for (Movie movie : movies) {
            String [] categories = movie.getCategories();
            for (String category : categories) {
                if (category.toLowerCase().equals(searchCategory.toLowerCase())) {
                    System.out.println(movie);
                    break;
                }
            }
        }
    }
}
