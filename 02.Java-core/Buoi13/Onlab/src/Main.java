import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import javax.sound.sampled.SourceDataLine;

public class Main<T> {
    public static void main(String[] args) throws Exception {
        // MyGeneric<Integer> myGeneric1 = new MyGeneric<>(1);
        // System.out.println(myGeneric1.getVariable());

        // MyGeneric<Double> myGeneric2 = new MyGeneric<>(5.6);
        // System.out.println(myGeneric2.getVariable());

        // MyGeneric<String> myGeneric3 = new MyGeneric<>("Hello Generic");
        // System.out.println(myGeneric3.getVariable());

        // String[] arrString = new String[] { "Java", "Python", "Ruby", "JS" };

        // Integer[] arrInt = new Integer[] { 1, 2, 3, 4, 5 };

        // Double[] arrDouble = new Double[] { 2.5, 57.2, 45.2, 1.54, 5.4 };

        // // Main<String> stringMain = new Main<>();
        // // Main<Integer> intMain = new Main<>();
        // // Main<Double> doubleMain = new Main<>();
        // System.out.println("Mang chuoi: ");
        // show(arrString);
        // System.out.println("Mang so nguyen: ");
        // show(arrInt);
        // System.out.println("Mang so thuc: ");
        // show(arrDouble);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Dung", 9.5));
        students.add(new Student(2, "Nga", 5.8));
        students.add(new Student(3, "Manh", 8.3));

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(4, "Dung", 5000000));
        teachers.add(new Teacher(5, "Nga", 6000000));
        teachers.add(new Teacher(6, "Manh", 8000000));

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", 4, "white"));
        animals.add(new Animal("Dog", 4, "black"));

        // System.out.println("Danh sách học sinh");
        // showStudent(students);
        // System.out.println("Danh sách giáo viên");
        // showTeacher(teachers);

        System.out.println("Danh sách học sinh");
        show(students);
        System.out.println("Danh sách giáo viên");
        show(teachers);
        System.out.println("Danh sách động vật");
        show(animals);
    }

    public static void showStudent(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void showTeacher(ArrayList<Teacher> teachers) {
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    public static void show(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // public void showArray(T[] arr) {
    // for (T item : arr) {
    // System.out.println(item);
    // }
    // }

    // public static <T> void show(T[] arr) {
    // for (T item : arr) {
    // System.out.println(item);
    // }
    // }
}
