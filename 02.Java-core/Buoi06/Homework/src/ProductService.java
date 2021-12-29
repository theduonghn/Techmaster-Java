import java.util.Scanner;

public class ProductService {
    public Product inputProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten san pham: ");
        String name = sc.nextLine();

        System.out.print("Nhap so luong: ");
        double quantity = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap don vi: ");
        String unit = sc.nextLine();

        System.out.print("Nhap gia dau vao: ");
        double inputPrice = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap gia ban: ");
        double sellingPrice = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong ban: ");
        double sellingQuantity = Double.parseDouble(sc.nextLine());

        return new Product(id, name, quantity, unit, inputPrice, sellingPrice, sellingQuantity);
    }

    public Product[] createProductArray(int size) {
        Product[] products = new Product[size];
        for (int i = 0; i < size; ++i) {
            System.out.println("Nhap san pham [" + i + "]");
            products[i] = inputProduct();
        }
        return products;
    }

    public double calculateProfit(Product product) {
        return (product.sellingPrice - product.inputPrice) * product.sellingQuantity;
    }

    public void showProducts(Product[] products) {
        for (Product p : products) {
            System.out.printf("%s, loi nhuan: %.1f\n", p, calculateProfit(p));
        }
    }

}
