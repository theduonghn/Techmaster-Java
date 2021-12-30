package model;
public class Car {
    private String model;
    private String color;
    private String brand;

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", color=" + color + ", model=" + model + "]";
    }

    public Car(String model, String color, String brand) {
        this.model = model;
        this.color = color;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void speed(double sp) {
        System.out.println(this.color + " " + this.brand + " " + this.model + " is running with speed " + sp + " km/h");
    }

    public void size(String s) {
        System.out.println(this.color + " " + this.brand + " " + this.model + " has the size " + s);
    }
}
