package vn.techmaster.usermanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.techmaster.usermanagement.exception.UserException;
import vn.techmaster.usermanagement.hash.Hashing;
import vn.techmaster.usermanagement.model.State;
import vn.techmaster.usermanagement.model.User;
import vn.techmaster.usermanagement.repository.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceInMemory implements UserService {
    private UserRepo userRepo;
    private Hashing hashing;

    @Override
    public User login(String email, String password) {
        Optional<User> oUser = userRepo.findUserByEmail(email);
        // Nếu user không tồn tại thì báo lỗi
        if (!oUser.isPresent()) {
            throw new UserException("User is not found");
        }

        User user = oUser.get();

        // User muốn login phải có trạng thái active
        if (user.getState() != State.ACTIVE) {
            throw new UserException("User is not activated");
        }

        // Kiểm tra password
        boolean isValid = hashing.validatePassword(password, user.getHashedPassword());
        if (isValid) {
            return user;
        } else {
            throw new UserException("Password is incorrect");
        }
    }

    @Override
    public Boolean logout(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User addUser(String fullName, String email, String password) {
        return userRepo.addPendingUser(fullName, email, hashing.hashPassword(password));
    }

    @Override
    public User addActiveUser(String fullName, String email, String password) {
        return userRepo.addUser(fullName, email, hashing.hashPassword(password), State.ACTIVE);
    }

    @Override
    public Boolean activateUser(String activation_code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updatePassword(String email, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updateEmail(String email, String newEmail) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
