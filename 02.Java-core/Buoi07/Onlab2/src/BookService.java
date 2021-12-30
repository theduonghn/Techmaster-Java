import java.lang.reflect.Array;
import java.util.Arrays;

public class BookService {
    public static Book[] getAllBooks() {
        Book[] books = new Book[3];
        books[0] = new Book(1, "Cuon theo chieu gio",
                new String[] { "Tinh cam", "Ngon tinh" },
                "Alibaba",
                1970,
                "New World");
        books[1] = new Book(2, "De men phieu luu ky",
                new String[] { "Phieu luu", "Gia tuong" },
                "To Hoai",
                1940,
                "Kim Dong");
        books[2] = new Book(3, "Chiec thuyen ngoai xa",
                new String[] { "Tinh cam", "Hien dai" },
                "Kim Lan",
                1980,
                "Van hoc");

        return books;
    }

    public static void getBooksByCategory(Book[] books, String category) {
        for (Book book : books) {
            if (Arrays.toString(book.getCategories()).contains(category)) {
                System.out.println(book);
            }
        }
    }

    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void searchBooksByName(Book[] books, String nameString) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(nameString.toLowerCase())) {
                System.out.println(book);
            }
        }
    }
}
