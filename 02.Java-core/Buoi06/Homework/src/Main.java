public class Main {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductService();
        Product[] products = productService.createProductArray(3);
        productService.showProducts(products);
    }
}
