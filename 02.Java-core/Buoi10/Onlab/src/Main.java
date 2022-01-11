import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Duong", 25, "Hai Ba Trung, Ha Noi");
        System.out.println(p1);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(new Person("Tuan", 35, "Ho Chi Minh"));
        list.add(new Person("Kien", 36, "Ho Chi Minh"));
        list.add(new Person("Ngoc", 25, "Ngoc Hoi"));
        list.add(new Person("Ha", 18, "Ha Giang"));
        list.add(new Person("Linh San", 1, "Bac Kinh"));

        System.out.println("Danh sach ban dau");
        show(list);

        Collections.sort(list);
        System.out.println("Danh sach sau khi sap xep");
        show(list);
    }

    public static void show(ArrayList<Person> list) {
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
