public class Product {
    public int id;
    public String name;
    public double quantity;
    public String unit;
    public double inputPrice;
    public double sellingPrice;
    public double sellingQuantity;

    public Product(int id, String name, double quantity, String unit, double inputPrice, double sellingPrice,
            double sellingQuantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.inputPrice = inputPrice;
        this.sellingPrice = sellingPrice;
        this.sellingQuantity = sellingQuantity;
    }

    @Override
    public String toString() {
        return "San pham - id: " + id +
                ", ten san pham: " + name +
                ", so luong: " + quantity +
                ", don vi: " + unit +
                ", gia nhap: " + inputPrice +
                ", gia ban: " + sellingPrice +
                ", so luong ban: " + sellingQuantity;
    }
}
