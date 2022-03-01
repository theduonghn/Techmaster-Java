import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> list = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String mobile = result.getString("mobile");
                LocalDate date = LocalDate.parse(result.getString("create_at"));

                list.add(new User(id, name, gender, address, mobile, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void show(List<User> list) {
        list.forEach(System.out::println);
    }

    public User getUserById(int findId) {
        String query = "SELECT * FROM users WHERE id = " + findId;

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String mobile = result.getString("mobile");
                LocalDate date = LocalDate.parse(result.getString("create_at"));

                return new User(id, name, gender, address, mobile, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsersByName(String findName) {
        String query = "SELECT * FROM users WHERE name LIKE '%" + findName + "%'";
        List<User> list = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String mobile = result.getString("mobile");
                LocalDate date = LocalDate.parse(result.getString("create_at"));

                list.add(new User(id, name, gender, address, mobile, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addUser(User user) {
        String query =
                "INSERT INTO `users`(`id`, `name`, `gender`, `address`, `mobile`, `create_at`)" + "VALUES (NULL,'" +
                        user.getName() + "','" + user.getGender() + "','" + user.getAddress() + "','" +
                        user.getMobile() + "'," + "CURRENT_DATE())";

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserAddress(User user, String newAddress) {
        String query = "UPDATE `users` SET `address` = '" + newAddress + "' WHERE id = " + user.getId();

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        String query = "DELETE FROM `users` WHERE id = " + user.getId();

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
