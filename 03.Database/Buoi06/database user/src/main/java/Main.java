import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        Connection conn = connectDatabase.connect();

//        Service service = new Service();
//        service.getAllUsers();
    }
}
