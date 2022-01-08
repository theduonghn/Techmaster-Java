package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Category;
import model.Product;

public class ProductService {
    public ArrayList<Product> createProductList() {
        return new ArrayList<Product>();
    }

    public void initProductList(ArrayList<Product> products) {
        Product p1 = new Product(1, "Chuoi", 20000, 135, Category.FOOD, 29);
        products.add(p1);

        Product p2 = new Product(2, "Vo hoc sinh", 10000, 260, Category.HOUSEHOLD, 153);
        products.add(p2);

        Product p3 = new Product(3, "Vay tre em", 150000, 25, Category.FASHION, 5);
        products.add(p3);

    }

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap cac thong tin cua mat hang: ");

        System.out.print("Nhap id: ");
        long id = Long.parseLong(sc.nextLine());

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia ban: ");
        long price = Long.parseLong(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        // TODO: handle error when categoryChoice is not valid
        System.out.println("Chon loai mat hang: ");
        for (int i = 0; i < Category.values().length; i++) {
            System.out.print(i + ". " + Category.values()[i] + "\t");
        }
        System.out.println();
        System.out.print("Nhap lua chon cua ban: ");
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

    public Product getProductById(ArrayList<Product> products, long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductsByCategory(ArrayList<Product> products, Category category) {
        ArrayList<Product> productsOfCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsOfCategory.add(product);
            }
        }
        return productsOfCategory;
    }

    public void showProductsByCategory(ArrayList<Product> products, Category category) {
        ArrayList<Product> productsOfCategory = getProductsByCategory(products, category);
        if (productsOfCategory.size() == 0) {
            System.out.println("Khong co san pham nao thuoc ve loai mat hang nay");
        } else {
            System.out.println("Cac san pham thuoc loai mat hang " + category + ": ");
            for (Product product : productsOfCategory) {
                System.out.println(product);
            }
        }
    }

    public void showProducts(ArrayList<Product> products) {
        System.out.println("Danh sach san pham: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProductsByName(ArrayList<Product> products, String searchName) {
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    public void updateProductName(Product product, String newName) {
        product.setName(newName);
    }

    public void updateProductPrice(Product product, long newPrice) {
        product.setPrice(newPrice);
    }

    public void deleteProduct(ArrayList<Product> products, Product product) {
        products.remove(product);
    }
}
