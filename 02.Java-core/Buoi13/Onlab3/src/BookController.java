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
                        System.out.println("Danh sách sách giáo khoa: ");
                        bookService.show(textBooks);
                        System.out.println("Danh sách báo: ");
                        bookService.show(newspapers);
                        System.out.println("Danh sách ebook: ");
                        bookService.show(ebooks);
                        break;
                    case 2:
                        System.out.print("Nhập tên sách: ");
                        String name = sc.nextLine();
                        System.out.println("Danh sách sách giáo khoa tìm được: ");
                        bookService.searchBooksByName(textBooks, name);
                        System.out.println("Danh sách báo tìm được: ");
                        bookService.searchBooksByName(newspapers, name);
                        System.out.println("Danh sách ebook tìm được: ");
                        bookService.searchBooksByName(ebooks, name);
                        break;
                    case 3:
                        System.out.print("Nhập thể loại: ");
                        String category = sc.nextLine();
                        System.out.println("Danh sách sách giáo khoa tìm được: ");
                        bookService.show(bookService.getBooksByCategory(textBooks, category));
                        System.out.println("Danh sách báo tìm được: ");
                        bookService.show(bookService.getBooksByCategory(newspapers, category));
                        System.out.println("Danh sách ebook tìm được: ");
                        bookService.show(bookService.getBooksByCategory(ebooks, category));
                        break;
                    case 4:
                        System.out.println("Ebook có lượt tải nhiều nhất: ");
                        System.out.println(bookService.getEbookWithMostDownload(ebooks));
                        break;
                    case 5:
                        System.out.println("Danh sách báo phát hành năm nay: ");
                        bookService.show(
                                bookService.getNewsPaperByPublishedYear(newspapers, LocalDate.now().getYear()));
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
}