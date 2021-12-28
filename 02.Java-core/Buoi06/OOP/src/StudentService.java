import java.util.Scanner;

public class StudentService {
    public Student inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin hoc vien");
        System.out.print("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap diem thuc hanh: ");
        double practicalPoint = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap diem ly thuyet: ");
        double theoreticalPoint = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap truong: ");
        String school = sc.nextLine();

        Student student = new Student(id, name, practicalPoint, theoreticalPoint, school);
        return student;
    }

    public double getAveragePoint(Student student) {
        return (student.practicalPoint + student.theoreticalPoint) / 2;
    }

}
