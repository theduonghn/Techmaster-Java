package vn.techmaster.demo.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import vn.techmaster.demo.model.User;
import vn.techmaster.demo.request.UserLoginRequest;
import vn.techmaster.demo.request.UserLoginResponse;

@Repository
public class UserRepository {
    private ConcurrentHashMap<Integer, User> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        users.put(1, new User(1, "user1", "user1@mail.com", "pw1", "avatar1"));
        users.put(2, new User(2, "user2", "user2@mail.com", "pw2", "avatar2"));
    }

    public UserLoginResponse login(UserLoginRequest request) {
        User user = this.getUserByUsername(request.username());
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(request.password())) {
            return new UserLoginResponse(user.getUsername(), user.getEmail(), user.getAvatar());
        } else {
            return null;
        }
    }

    public User getUserByUsername(String username) {
        for (Map.Entry<Integer, User> row : this.users.entrySet()) {
            User user = row.getValue();
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
