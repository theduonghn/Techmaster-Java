import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    public ArrayList<Product> createProductList() {
        return new ArrayList<Product>();
    }

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia ban: ");
        long price = Long.parseLong(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println("Chon loai mat hang: ");
        for (int i = 0; i < Category.values().length; i++) {
            System.out.println(i + ". " + Category.values()[i]);
        }
        int categoryChoice = Integer.parseInt(sc.nextLine());
        Category category = Category.values()[categoryChoice];

        System.out.print("Nhap so luong ban: ");
        int soldQuantity = Integer.parseInt(sc.nextLine());

        Product product = new Product(id, name, price, quantity, category, soldQuantity);
        return product;
    }

    public void addProduct(ArrayList<Product> products, Product product) {
        products.add(product);
    }

    public void showProducts(ArrayList<Product> products) {
        System.out.println("Danh sach san pham: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
