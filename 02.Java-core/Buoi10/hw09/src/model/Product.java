package model;

import util.MyFormat;

public class Product implements Comparable<Product> {
    private long id;
    private String name;
    private long price;
    private int quantity;
    private Category category;
    private int soldQuantity;

    public Product(long id, String name, long price, int quantity, Category category, int soldQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.soldQuantity = soldQuantity;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", price='" + MyFormat.formatVnd(getPrice()) + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", category='" + getCategory() + "'" +
                ", soldQuantity='" + getSoldQuantity() + "'" +
                "}";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    @Override
    public int compareTo(Product o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

}
