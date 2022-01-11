import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static <T> void main(String[] args) throws Exception {
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film(1, "Chua the cua nhung chiec nhan", 360, "Fantasy", 1000000, 2001));
        films.add(new Film(2, "Cuon theo chieu gio", 189, "Classic", 50045, 2005));
        films.add(new Film(3, "The Hobbit", 412, "Comedy", 456453, 1997));
        films.add(new Film(4, "Snow White", 411, "Thriller", 455342, 1964));
        films.add(new Film(5, "Beauty and the Beast", 210, "Scifi", 4278, 2007));
        films.add(new Film(6, "Up", 95, "Fantasy", 45642, 2014));
        films.add(new Film(7, "The Fountain", 150, "Adventure", 456478, 2020));
        films.add(new Film(8, "The Founder", 180, "Adventure", 4562, 2021));
        films.add(new Film(9, "You are the apple of my eye", 320, "Fantasy", 45678, 1905));
        films.add(new Film(10, "Platform", 120, "Action", 41137565, 1955));

        System.out.println("Danh sach phim ban dau");
        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println();

        System.out.println("Sap xep theo ten");
        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println();

        System.out.println("Sap xep theo do dai");
        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o1.getLength() - o2.getLength();
            }
        });
        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println();

        System.out.println("Sap xep theo luot xem");
        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o1.getView() - o2.getView();
            }
        });
        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println();

        System.out.println("Sap xep theo nam phat hanh");
        Collections.sort(films, new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o1.getYear() - o2.getYear();
            }
        });
        for (Film film : films) {
            System.out.println(film);
        }
        System.out.println();
    }
}
