import util.MyFormat;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    static Scanner sc = new Scanner(System.in);
    static ProductService productService = new ProductService();
    static CategoryService categoryService = new CategoryService();
    static ArrayList<Product> products = productService.initProductList();
    static boolean continueProgram = true;

    public static void run() {
        menu();
    }

    public static void menu() {
        while (continueProgram) {
            try {
                System.out.println("--------------------");
                System.out.println("1. Danh sách sản phẩm theo danh mục");
                System.out.println("2. Danh sách sản phẩm theo hãng");
                System.out.println("3. Danh sách sản phẩm theo mức giá");
                System.out.println("4. Tìm kiếm sản phẩm theo tên");
                System.out.println("5. Thống kê số lượng sản phẩm theo danh mục");
                System.out.println("0. Thoát chương trình");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        getProductsByCategory();
                        break;
                    case 2:
                        getProductsByCompany();
                        break;
                    case 3:
                        getProductsByPriceRange();
                        break;
                    case 4:
                        searchProductsByName();
                        break;
                    case 5:
                        countProductsOfCategories();
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

    private static void countProductsOfCategories() {
        for (Category c : Category.values()) {
            System.out.println(c + ": " + productService.getProductsByCategory(products, c).size() + " sản phẩm");
        }
    }

    private static void searchProductsByName() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        productService.searchProductsByName(products, name);
    }

    private static void getProductsByPriceRange() {
        System.out.println("Danh sách sản phẩm theo mức giá: ");
        System.out.println("Dưới 2 triệu VND");
        productService.showProducts(productService.getProductsByPriceRange(products, 0, 2000000L));
        System.out.println("Từ 2 - 4 triệu VND");
        productService.showProducts(productService.getProductsByPriceRange(products, 2000000L, 4000000L));
        System.out.println("Từ 4 - 7 triệu VND");
        productService.showProducts(productService.getProductsByPriceRange(products, 4000000L, 7000000L));
        System.out.println("Từ 7 - 13 triệu VND");
        productService.showProducts(productService.getProductsByPriceRange(products, 7000000L, 13000000));
        System.out.println("Trên 13 triệu VND");
        productService.showProducts(productService.getProductsByPriceRange(products, 13000000, Long.MAX_VALUE));
    }

    private static void getProductsByCompany() {
        System.out.println("Nhập tên hãng: ");
        String company = sc.nextLine();
        ArrayList<Product> productsByCompany = productService.getProductsByCompany(products, company);
        if (productsByCompany.size() == 0) {
            System.out.println("Không có sản phẩm nào thuộc hãng " + company);
        } else {
            System.out.println("Sản phẩm thuộc hãng " + company + ": ");
            productService.showProducts(productsByCompany);
        }
    }

    private static void getProductsByCategory() {
        Category category = categoryService.chooseCategory();
        ArrayList<Product> productsByCategory = productService.getProductsByCategory(products, category);
        System.out.println("Sản phẩm thuộc danh mục " + category + ": ");
        productService.showProducts(productsByCategory);
    }
}
