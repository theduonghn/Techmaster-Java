import java.util.Scanner;

public class CategoryService {
    Scanner sc = new Scanner(System.in);

    public Category chooseCategory() {
        while (true) {
            try {
                System.out.println("Chọn danh mục: ");
                for (int i = 0; i < Category.values().length; i++) {
                    System.out.println((i + 1) + ". " + Category.values()[i]);
                }
                int categoryChoice = Integer.parseInt(sc.nextLine());
                Category category = Category.values()[categoryChoice - 1];

                return category;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Danh mục không hợp lệ");
            }
        }
    }
}
