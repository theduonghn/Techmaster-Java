import java.util.ArrayList;
import java.util.Collections;

import model.Book;
import service.BookService;

public class Main {
    public static void main(String[] args) throws Exception {
        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(1);
        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(3);
        // numbers.add(5);

        // System.out.println(numbers);

        // System.out.println("Use for i");
        // for (int i = 0; i < numbers.size(); i++) {
        // System.out.println(numbers.get(i));
        // }

        // System.out.println("Use foreach");
        // for (Integer num : numbers) {
        // System.out.println(num);
        // }

        // numbers.add(8);

        // System.out.println("List after added an element");
        // System.out.println(numbers);

        // numbers.add(3, 7);
        // System.out.println("List after added an element");
        // System.out.println(numbers);

        // System.out.println("List after deleted an element");
        // numbers.remove(3);
        // System.out.println(numbers);

        // System.out.println("List after deleted an element by value");
        // numbers.remove(Integer.parseInt("5"));
        // System.out.println(numbers);

        // numbers.set(1, 4);
        // System.out.println(numbers);

        // Collections.sort(numbers);
        // System.out.println("Danh sach sau khi sap xep");
        // System.out.println(numbers);

        // Collections.shuffle(numbers);
        // System.out.println("Danh sach sau khi xao tron");
        // System.out.println(numbers);

        // ArrayList<String> names = new ArrayList<>();
        // names.add("Hung");
        // names.add("Tuan");
        // names.add("Duong");
        // names.add("Hai");
        // names.add("Hung");
        // names.add("Nga");

        // System.out.println(names);

        // for (String name : names) {
        // System.out.print(name + "\t");
        // }
        // System.out.println();

        // System.out.println();
        // names.remove("Hung");
        // System.out.println(names);

        BookService service = new BookService();
        ArrayList<Book> books = service.getAllBooks();
        service.show(books);
        System.out.println("Danh sach can tim");
        service.searchBooksByTitle(books, "de men");

        Book updateBook = service.searchBookById(books, 2);
        service.updateBook(updateBook, "Nha gia kim");
        System.out.println("Danh sach sau khi sua");
        service.show(books);

        Book deleteBook = service.searchBookById(books, 2);
        service.deleteBook(books, deleteBook);
        System.out.println("Danh sach sau khi xoa");
        service.show(books);

        System.out.println("Them sach moi");
        Book newBook = service.createNewBook();
        service.addNewBook(books, newBook);
        System.out.println("Danh sach sau khi them");
        service.show(books);
    }
}
