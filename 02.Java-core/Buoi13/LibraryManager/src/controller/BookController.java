package controller;

import model.Ebook;
import model.Newspaper;
import model.TextBook;
import service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookController {
    static Scanner sc = new Scanner(System.in);
    static BookService bookService = new BookService();
    static ArrayList<TextBook> textBooks = bookService.initTextBooks();
    static ArrayList<Newspaper> newspapers = bookService.initNewspapers();
    static ArrayList<Ebook> ebooks = bookService.initEbooks();
    static boolean continueProgram = true;

    public static void run() {
        menu();
    }

    public static void menu() {
        while (continueProgram) {
            try {
                System.out.println("--------------------");
                System.out.println("1. In danh sách");
                System.out.println("2. Tìm sách theo tên");
                System.out.println("3. Tìm sách theo thể loại");
                System.out.println("4. Ebook có lượt tải nhiều nhất");
                System.out.println("5. Các báo phát hành năm nay");
                System.out.println("0. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        showLists();
                        break;
                    case 2:
                        searchBooksByName();
                        break;
                    case 3:
                        searchBooksByCategory();
                        break;
                    case 4:
                        getEbookWithMostDownload();
                        break;
                    case 5:
                        getNewsPaperThisYear();
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

    private static void getNewsPaperThisYear() {
        System.out.println("Danh sách báo phát hành năm nay: ");
        bookService.show(bookService.getNewsPaperByPublishedYear(newspapers, LocalDate.now().getYear()));
    }

    private static void getEbookWithMostDownload() {
        System.out.println("Ebook có lượt tải nhiều nhất: ");
        System.out.println(bookService.getEbookWithMostDownload(ebooks));
    }

    private static void searchBooksByCategory() {
        System.out.print("Nhập thể loại: ");
        String category = sc.nextLine();
        System.out.println("Các sách thuộc thể loại " + category + " : ");
        bookService.show(bookService.getBooksByCategory(textBooks, category));
        bookService.show(bookService.getBooksByCategory(newspapers, category));
        bookService.show(bookService.getBooksByCategory(ebooks, category));
    }

    private static void searchBooksByName() {
        System.out.print("Nhập tên sách: ");
        String name = sc.nextLine();
        System.out.println("Các sách tìm được: ");
        bookService.searchBooksByName(textBooks, name);
        bookService.searchBooksByName(newspapers, name);
        bookService.searchBooksByName(ebooks, name);
    }

    private static void showLists() {
        System.out.println("Danh sách sách giáo khoa: ");
        bookService.show(textBooks);
        System.out.println("Danh sách báo: ");
        bookService.show(newspapers);
        System.out.println("Danh sách ebook: ");
        bookService.show(ebooks);
    }
}