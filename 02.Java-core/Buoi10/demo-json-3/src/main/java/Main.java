import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService();
        ArrayList<Person> list = service.getAllPerson();
        service.show(list);
    }
}
