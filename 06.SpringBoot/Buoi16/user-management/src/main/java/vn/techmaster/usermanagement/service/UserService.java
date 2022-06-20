package vn.techmaster.usermanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.techmaster.usermanagement.model.User;

@Service
public interface UserService {
    public User login(String email, String password);

    public Boolean logout(String email);

    public User addUser(String fullName, String email, String password);

    public User addActiveUser(String fullName, String email, String password);

    public Boolean activateUser(String activation_code);

    public Boolean updatePassword(String email, String password);

    public Boolean updateEmail(String email, String newEmail);

    public Optional<User> findByEmail(String email);

    public User findById(String id);
}
