import java.util.Scanner;

public class Student {
    public int id;
    public String name;
    public double practicalPoint;
    public double theoreticalPoint;
    public String school;

    public Student(int id, String name, double practicalPoint, double theoreticalPoint, String school) {
        this.id = id;
        this.name = name;
        this.practicalPoint = practicalPoint;
        this.theoreticalPoint = theoreticalPoint;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [id: " + id +
                ", Ten: " + name +
                ", Diem thuc hanh: " + practicalPoint +
                ", Diem ly thuyet: " + theoreticalPoint
                + ", Truong: " + school + "]";
    }

    public double getAveragePoint() {
        return (practicalPoint + theoreticalPoint) / 2;
    }

}
