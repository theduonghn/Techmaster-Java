import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        addPersons(persons);

        System.out.println("Sap xep theo tuoi: ");
        persons.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(person -> System.out.println(person));

        System.out.println("Loc nguoi lon tuoi hon 25: ");
        persons.stream().filter(person -> person.getAge() > 25)
                .forEach(person -> System.out.println(person));
    }

    private static void addPersons(List<Person> persons) {
        persons.add(new Person("Duong", 25, "HN"));
        persons.add(new Person("Ngoc", 27, "HCM"));
        persons.add(new Person("Linh", 32, "DN"));
        persons.add(new Person("Nga", 50, "TN"));
        persons.add(new Person("Hang", 19, "PT"));
    }
}
