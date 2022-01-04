public class Square extends Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Square [width=" + width +
                ", area=" + calcArea() +
                ", perimeter=" + calcPerimeter() +
                "]";

    }

    @Override
    public double calcArea() {
        return width * width;
    }

    @Override
    public double calcPerimeter() {
        return 4 * width;
    }
}
