package com.techmaster.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmaster.login.hash.Hashing;
import com.techmaster.login.model.State;
import com.techmaster.login.model.User;
import com.techmaster.login.repository.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceInMemory implements UserService {
    private UserRepo userRepo;
    private Hashing hashing;

    @Override
    public User login(String email, String password) {
        Optional<User> oUser = userRepo.findUserByEmail(email);
        if (!oUser.isPresent()) {
            return null;
        }

        User user = oUser.get();
        return hashing.validatePassword(password, user.getHashedPassword()) ? user : null;
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
        return userRepo.addUser(fullName, email, hashing.hashPassword(password), State.ACTIVATED);
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
