package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Category;
import model.Product;
import service.ProductService;

public class ProductController {
    static Scanner sc = new Scanner(System.in);
    static ProductService service = new ProductService();
    static ArrayList<Product> products = service.createProductList();

    public static void showMenu() {
        System.out.println("----------" + "MENU CHINH" + "----------");
        System.out.println("1. Xem toan bo san pham");
        System.out.println("2. Them 1 san pham");
        System.out.println("3. Tim san pham theo ten");
        System.out.println("4. Tim san pham theo ID");
        System.out.println("5. Liet ke san pham theo mat hang");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Nhap lua chon cua ban: ");
    }

    public static void showSubMenu(Product product) {
        System.out.println("----------" + "Menu san pham" + "----------");
        System.out.println("1. Sua ten san pham");
        System.out.println("2. Sua gia san pham");
        System.out.println("3. Xoa san pham");
        System.out.println("0. Quay ve menu chinh");
        System.out.print("Nhap lua chon cua ban: ");
    }

    public static void chooseMenuItem() {
        boolean isContinue = true;

        while (isContinue) {
            showMenu();

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    service.showProducts(products);
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    System.out.println("Nhap ten san pham: ");
                    String searchName = sc.nextLine();
                    service.searchProductsByName(products, searchName);
                    break;
                case 4:
                    getProductById();
                    break;
                case 5:
                    showProductsByCategory();
                    break;
                case 0:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
                    break;
            }
        }
    }

    private static void getProductById() {
        System.out.print("Nhap ID san pham: ");
        long id = Long.parseLong(sc.nextLine());
        Product product = service.getProductById(products, id);
        if (product == null) {
            System.out.println("Khong co san pham nao co ID nhu tren");
        } else {
            System.out.println("San pham tim duoc: ");
            System.out.println(product);
            chooseSubMenuItem(product); // Go to submenu
        }
    }

    private static void showProductsByCategory() {
        // TODO: handle error when categoryChoice is not valid
        System.out.println("Chon loai mat hang: ");
        for (int i = 0; i < Category.values().length; i++) {
            System.out.print(i + ". " + Category.values()[i] + "\t");
        }
        System.out.println();
        System.out.print("Nhap lua chon cua ban: ");
        int categoryChoice = Integer.parseInt(sc.nextLine());
        Category category = Category.values()[categoryChoice];
        service.showProductsByCategory(products, category);
    }

    private static void addProduct() {
        Product product = service.createProduct();
        service.addProduct(products, product);
        System.out.println("San pham da them: ");
        System.out.println(product);
    }

    public static void chooseSubMenuItem(Product product) {
        boolean isContinue = true;

        while (isContinue) {
            showSubMenu(product);

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    updateProductName(product);
                    break;
                case 2:
                    updateProductPrice(product);
                    break;
                case 3:
                    service.deleteProduct(products, product);
                    System.out.println("Da xoa san pham");
                    isContinue = false;
                    break;
                case 0:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
                    break;
            }
        }
    }

    private static void updateProductPrice(Product product) {
        System.out.print("Nhap gia moi: ");
        long newPrice = Long.parseLong(sc.nextLine());
        service.updateProductPrice(product, newPrice);
        System.out.println("San pham sau khi sua gia: ");
        System.out.println(product);
    }

    private static void updateProductName(Product product) {
        System.out.print("Nhap ten moi: ");
        String newName = sc.nextLine();
        service.updateProductName(product, newName);
        System.out.println("San pham sau khi sua ten: ");
        System.out.println(product);
    }

    public static void run() {
        service.initProductList(products);
        chooseMenuItem();
    }
}
