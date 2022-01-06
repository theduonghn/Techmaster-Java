package service;
import java.util.ArrayList;
import java.util.Scanner;

import model.Book;

public class BookService {
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "De men phieu luu ki", "To Hoai", "Phieu luu, Thieu nhi"));
        books.add(new Book(2, "Cuon theo chieu gio", "N/A", "Co dien, Lang man"));
        books.add(new Book(3, "Vo nhat", "Kim Lan", "Hien dai"));

        return books;
    }

    public void show(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBooksByTitle(ArrayList<Book> books, String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public Book searchBookById(ArrayList<Book> books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(Book book, String newTitle) {
        book.setTitle(newTitle);
    }

    public void deleteBook(ArrayList<Book> books, Book book) {
        books.remove(book);
    }

    public Book createNewBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten: ");
        String title = sc.nextLine();
        System.out.println("Nhap tac gia: ");
        String author = sc.nextLine();
        System.out.println("Nhap the loai: ");
        String category = sc.nextLine();

        Book newBook = new Book(id, title, author, category);

        return newBook;
    }

    public void addNewBook(ArrayList<Book> books, Book newBook) {
        books.add(newBook);
    }
}
