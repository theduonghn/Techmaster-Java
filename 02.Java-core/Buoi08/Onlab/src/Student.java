import java.time.LocalDate;

public class Student extends Person {
    private String classroom;
    private double point;

    public Student(int id, String name, LocalDate date, String classroom, double point) {
        super(id, name, date);
        this.classroom = classroom;
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString() + ", classroom=" + classroom + ", point=" + point;
    }
}
