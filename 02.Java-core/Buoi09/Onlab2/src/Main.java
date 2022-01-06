import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductService();
        ArrayList<Product> products = productService.createProductList();
        Product p1 = productService.createProduct();
        productService.addProduct(products, p1);

        Product p2 = productService.createProduct();
        productService.addProduct(products, p2);

        Product p3 = productService.createProduct();
        productService.addProduct(products, p3);

        productService.showProducts(products);
    }
}
