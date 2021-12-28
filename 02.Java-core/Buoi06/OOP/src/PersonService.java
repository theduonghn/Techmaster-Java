import java.util.Scanner;

public class PersonService {
    public Person[] getAllPersons() {
        Person[] persons = new Person[3];
        persons[0] = new Person(1, "Ngoc", 25, Gender.FEMALE, "HG");
        persons[1] = new Person(2, "Linh", 26, Gender.MALE, "HN");
        persons[2] = new Person(3, "San", 27, Gender.FEMALE, "DN");

        return persons;
    }

    public void show(Person[] persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public Person createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten: ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Lua chon gioi tinh: ");
        System.out.println("1 - Nu");
        System.out.println("0 - Nam");
        int choice = Integer.parseInt(sc.nextLine());
        Gender gender;
        if (choice == 1) {
            gender = Gender.FEMALE;
        } else if (choice == 0) {
            gender = Gender.MALE;
        } else {
            System.out.println("Khong co lua chon nay");
            gender = Gender.OTHER;
        }
        System.out.println("Nhap dia chi: ");
        String address = sc.nextLine();

        Person newPerson = new Person(id, name, age, gender, address);
        return newPerson;
    }

    public Person[] addPerson(int size) {
        Person[] persons = new Person[size];
        for (int i = 0; i < size; ++i) {
            persons[i] = createPerson();
        }
        return persons;
    }
}
