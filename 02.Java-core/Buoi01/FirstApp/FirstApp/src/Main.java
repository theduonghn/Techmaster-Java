public class Main {
    public static double point; // Bien toan cuc

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hi Java");

        int age;
        age = 25;

        long salary = 30000000L;

        // float height = 1.5f;
        // double weight = 40.5;

        char ch = 'N';

        point = 10;

        myMethod();

        Person p = new Person();
        p.introduce();
        Person.hello();

        System.out.println(Person.sum(5, 7));
        System.out.println(Person.subtract(50, 40));

        System.out.println(9 / 2.5);
        System.out.println(Person.divide(9, 2.5));
        System.out.println(Person.multiply(5, 4));

        boolean isCheck = Person.compareNumber(5, 8);
        System.out.println(isCheck);

        String name = "Ngoc";
        System.out.println(name);

        // double weight = 75;
        // double height = 1.7;
        double weight = 40.5;
        double height = 1.5;
        double bmi = calculateBmi(weight, height);
        System.out.println("Chi so BMI: " + bmi);
        System.out.printf("Chi so BMI cua ban la %.2f", bmi);
        System.out.printf("\nCan nang: %.1f, chieu cao: %.1f, BMI: %.1f", weight, height, bmi);

        String ten = "Duong";
        int tuoi = 24;
        String diaChi = "Hai Ba Trung, Ha Noi";
        System.out.printf("\nToi ten la %s, nam nay toi %d tuoi, toi den tu %s", ten, tuoi, diaChi);
    }

    public static void myMethod() {
        // age = 5;
        System.out.println("Xin chào tôi tên là Ngọc");
    }

    public static double calculateBmi(double weight, double height) {
        return weight / (height * height);
    }
}