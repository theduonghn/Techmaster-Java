import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        List<User> list = service.getAllUsers();
//        service.show(list);

//        User user = service.getUserById(1);
//        System.out.println(user);
//        List<User> listName = service.getUsersByName("debi");
//        service.show(listName);
//        service.deleteUser(user);
        User newUser = new User("Ngoc", "Female", "Hanoi", "0123456789");
        service.addUser(newUser);

        User user = service.getUserById(8);
        service.updateUserAddress(user, "Ha Giang");
    }
}
