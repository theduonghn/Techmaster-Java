import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class BookService {
    public ArrayList<TextBook> initTextBooks() {
        ArrayList<TextBook> list = new ArrayList<>();

        TextBook b1 = new TextBook(1, "Ngữ văn 11", new ArrayList<String>() {{
            add("Sách giáo khoa");
            add("Văn học");
        }}, "NXB Giáo dục", 2015, 475, 300, "Nguyễn Văn A");
        list.add(b1);

        TextBook b2 = new TextBook(2, "Đại số 10", new ArrayList<String>() {{
            add("Sách giáo khoa");
            add("Toán học");
        }}, "NXB Giáo dục", 2015, 124, 124, "Trần Văn B");
        list.add(b2);

        TextBook b3 = new TextBook(3, "Bài tập sinh học 12", new ArrayList<String>() {{
            add("Sách bài tập");
            add("Sinh học");
        }}, "NXB Giáo dục", 2015, 440, 152, "Lê Thị C");
        list.add(b3);

        return list;
    }

    public ArrayList<Newspaper> initNewspapers() {
        ArrayList<Newspaper> list = new ArrayList<>();

        Newspaper b4 = new Newspaper(4, "Tuổi trẻ", new ArrayList<String>() {{
            add("Báo giấy");
        }}, "NXB Tri thức", LocalDate.of(2019, 2, 15), 120, 21);
        list.add(b4);

        Newspaper b5 = new Newspaper(5, "Tạp chí xe hơi", new ArrayList<String>() {{
            add("Tạp chí");
        }}, "NXB Trẻ", LocalDate.of(2022, 4, 16), 132, 52);
        list.add(b5);

        Newspaper b6 = new Newspaper(6, "Lao động", new ArrayList<String>() {{
            add("Báo giấy");
        }}, "NXB Lao động", LocalDate.of(2022, 11, 9), 240, 12);
        list.add(b6);

        return list;
    }

    public ArrayList<Ebook> initEbooks() {
        ArrayList<Ebook> list = new ArrayList<>();

        Ebook b7 = new Ebook(7, "Cuốn theo chiều gió", new ArrayList<String>() {{
            add("Văn học");
            add("Cổ điển");
            add("Tiểu thuyết");
        }}, "NXB Lao động", 1980, 2.4, "ảnh 1", 3144);
        list.add(b7);

        Ebook b8 = new Ebook(8, "Lão hạc", new ArrayList<String>() {{
            add("Văn học");
            add("Cổ điển");
            add("Truyện ngắn");
        }}, "NXB Văn học", 1965, 2.3, "ảnh 2", 1231);
        list.add(b8);

        Ebook b9 = new Ebook(9, "Đại số tuyến tính", new ArrayList<String>() {{
            add("Sách giáo khoa");
            add("Toán học");
            add("Học tập");
        }}, "NXB Bách Khoa", 2014, 5.1, "ảnh 3", 1215);
        list.add(b9);

        return list;
    }

    public void show(ArrayList<? extends Book> list) {
        for (Book book : list) {
            System.out.println(book);
        }
    }

    public void searchBooksByName(ArrayList<? extends Book> list, String name) {
        for (Book b : list) {
            if (b.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(b);
            }
        }
    }

    public ArrayList<? extends Book> getBooksByCategory(ArrayList<? extends Book> list, String category) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : list) {
            ArrayList<String> categories = b.getCategories();
            for (String c : categories) {
                if (c.toLowerCase().equals(category.toLowerCase())) {
                    result.add(b);
                    break;
                }
            }
        }
        return result;
    }

    public Ebook getEbookWithMostDownload(ArrayList<Ebook> list) {
        Ebook result = list.get(0);
        int max = list.get(0).getDownload();
        for (Ebook b : list) {
            if (b.getDownload() > max) {
                max = b.getDownload();
                result = b;
            }
        }
        return result;
    }

    public ArrayList<Newspaper> getNewsPaperByPublishedYear(ArrayList<Newspaper> list, int year) {
        ArrayList<Newspaper> result = new ArrayList<>();
        for (Newspaper b : list) {
            if (b.getPublishedDate().getYear() == year) {
                result.add(b);
            }
        }
        return result;
    }
}
