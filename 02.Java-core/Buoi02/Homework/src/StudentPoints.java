import java.util.Scanner;

public class StudentPoints {
    // This class contains methods:
    // - get average points of student
    // - get result of student (passed or failed)

    // Passed point
    public static final double PASSED_POINT = 6;

    public static void inputOutputPoint() {
        // Crreate scanner
        Scanner sc = new Scanner(System.in);

        // Input pratical point and theoretical point
        System.out.println("Nhap diem thuc hanh: ");
        double practicalPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap diem ly thuyet: ");
        double theoreticalPoint = Double.parseDouble(sc.nextLine());

        // Calculate average point
        double averagePoint = getAveragePoint(practicalPoint, theoreticalPoint);
        System.out.printf("Diem trung binh: %.2f\n", averagePoint);

        // Calculate result
        String result = getResult(averagePoint);
        System.out.printf("Hoc vien da %s\n", result);
    }

    public static double getAveragePoint(double practicalPoint, double theoreticalPoint) {
        return (practicalPoint + theoreticalPoint) / 2;
    }

    public static String getResult(double averagePoint) {
        String result = averagePoint < PASSED_POINT ? "truot :(" : "dat ^^";
        return result;
    }
}
