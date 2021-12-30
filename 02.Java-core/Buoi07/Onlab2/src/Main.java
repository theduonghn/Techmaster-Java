public class Main {
    public static void main(String[] args) throws Exception {
        Book[] books = BookService.getAllBooks();
        System.out.println("Tat ca sach");
        BookService.printBooks(books);
        System.out.println("Sach the loai tinh cam");
        BookService.getBooksByCategory(books, "Tinh cam");
        System.out.println("Tim kiem sach");
        BookService.searchBooksByName(books, "cuon Theo");
    }
}
