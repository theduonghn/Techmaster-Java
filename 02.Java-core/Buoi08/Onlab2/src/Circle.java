public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=%.2f, area=%.2f, perimeter=%.2f]".formatted(
                radius, calcArea(), calcPerimeter());
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }
}
