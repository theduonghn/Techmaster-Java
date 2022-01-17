import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> initProductList() {
        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Product("1", "iPhone 13 Pro Max 128GB",
                "iPhone 13 Pro Max xứng đáng là một chiếc iPhone lớn nhất, mạnh mẽ nhất và có thời lượng pin dài nhất từ trước đến nay sẽ cho bạn trải nghiệm tuyệt vời, từ những tác vụ bình thường cho đến các ứng dụng chuyên nghiệp.",
                31990000, 135, 124, "Apple", new ArrayList<Category>() {
            {
                add(Category.PHONE);
                add(Category.APPLE);
            }
        });
        products.add(p1);

        Product p2 = new Product("2", "OPPO Reno6 Z 5G",
                "Không chỉ đưa bạn đến những trải nghiệm đầy phấn khích của mạng 5G siêu tốc, OPPO Reno6 Z 5G còn là chiếc điện thoại tuyệt vời để lưu giữ cảm xúc. Chụp ảnh và quay video chân dung chưa bao giờ thú vị đến thế với loạt tính năng chuyên nghiệp, đầy nghệ thuật.",
                9490000, 465, 152, "Oppo", new ArrayList<Category>() {
            {
                add(Category.PHONE);
            }
        });
        products.add(p2);

        Product p3 = new Product("3", "Laptop Acer Nitro Gaming AN515-45-R6EV R5 5600H/8GB/512GB SSD/GTX1650 4GB/Win11",
                "Không cần phải bỏ ra quá nhiều tiền, bạn vẫn có thể là người dẫn đầu cuộc chơi với Acer Nitro Gaming 5 AN515 45 R6EV phiên bản chạy AMD Ryzen 5000 series. Sức mạnh của tiến trình 7nm hiện đại kết hợp cùng card đồ họa kiến trúc Turing mang tới một chiếc máy tính chơi game xuất sắc.",
                21999000, 115, 21, "Acer", new ArrayList<Category>() {
            {
                add(Category.LAPTOP);
            }
        });
        products.add(p3);

        Product p4 =
                new Product("4", "Laptop Acer Nitro Gaming AN515-57-54MV i5 11400H/8GB/512GB SSD/RTX 3050 4GB/Win11",
                        "Acer Nitro Gaming AN515-57-54MV là chiếc laptop gaming có mức giá vừa phải nhưng lại sở hữu cấu hình ấn tượng với bộ vi xử lý Intel thế hệ thứ 11 mạnh mẽ và card đồ họa rời RTX 30 series. Diện mạo mới, sức mạnh mới, Nitro 5 sẽ cùng bạn vươn tới những đỉnh cao.",
                        24499000, 123, 28, "Acer", new ArrayList<Category>() {
                    {
                        add(Category.LAPTOP);
                    }
                });
        products.add(p4);

        Product p5 = new Product("5", "Apple Watch Series 6 GPS 40mm viền nhôm dây cao su",
                "Trang bị đầy đủ những cảm biến sức khỏe hàng đầu, Apple Watch Series 6 có khả năng đo nhịp tim, điện tâm đồ, nồng độ oxy trong máu và hỗ trợ tập luyện chuyên nghiệp, cho bạn sự yên tâm về sức khỏe.",
                8499000, 125, 120, "Apple", new ArrayList<Category>() {
            {
                add(Category.ACCESSORY);
                add(Category.APPLE);
            }
        });
        products.add(p5);

        Product p6 = new Product("6", "Đồng hồ Casio LTP-V006L-7B2UDF", "Đồng hồ cao cấp", 815000, 451, 123, "Casio",
                new ArrayList<Category>() {
                    {
                        add(Category.ACCESSORY);
                    }
                });
        products.add(p6);

        return products;
    }

    public void addProduct(ArrayList<Product> products, Product product) {
        products.add(product);
    }

    public Product getProductById(ArrayList<Product> products, String id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductsByCategory(ArrayList<Product> products, Category category) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            ArrayList<Category> categories = product.getCategories();
            for (Category c : categories) {
                if (c == category) {
                    result.add(product);
                }
            }
        }
        return result;
    }

    public ArrayList<Product> getProductsByCompany(ArrayList<Product> products, String company) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCompany().toLowerCase().equals(company.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public ArrayList<Product> getProductsByPriceRange(ArrayList<Product> products, long minPrice, long maxPrice) {
        // Liệt kê sản phẩm từ giá min đến (nhưng không bao gồm) giá max
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() < maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public void showProducts(ArrayList<Product> products) {
        System.out.println("Danh sách sản phẩm: ");
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
