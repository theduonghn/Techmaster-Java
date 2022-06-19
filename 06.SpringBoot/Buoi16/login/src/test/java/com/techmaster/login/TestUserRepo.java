package com.techmaster.login;

import org.junit.jupiter.api.Test;

import com.techmaster.login.model.State;
import com.techmaster.login.model.User;
import com.techmaster.login.repository.UserRepo;
import static org.assertj.core.api.Assertions.*;

class TestUserRepo {
    @Test
    void addUser() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Nguyen Van", "van@gmail.com", "123", State.PENDING);
        assertThat(user).isNotNull();
        System.out.println("id=" + user.getId());
        assertThat(user.getId()).isNotNull();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test
    void isEmailExist() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("Nguyen Van", "van@gmail.com", "123", State.PENDING);
        userRepo.addUser("Nguyen Ngoc", "ngoc@gmail.com", "123", State.PENDING);
        userRepo.addUser("Le Son", "son@gmail.com", "123", State.PENDING);

        assertThat(userRepo.isEmailExist("van@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("vAn@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("van@gmail.COM")).isTrue();
        assertThat(userRepo.isEmailExist("nam@gmail.com")).isFalse();
    }

    @Test
    void findUserByEmail() {
        UserRepo userRepo = new UserRepo();
        User user1 = userRepo.addUser("Nguyen Van", "van@gmail.com", "123", State.PENDING);
        User user2 = userRepo.addUser("Nguyen Ngoc", "ngoc@gmail.com", "123", State.PENDING);
        User user3 = userRepo.addUser("Le Son", "son@gmail.com", "123", State.PENDING);

        assertThat(userRepo.findUserByEmail("van@gmail.com")).contains(user1);
        assertThat(userRepo.findUserByEmail("vAn@gmail.com")).contains(user1);
        assertThat(userRepo.findUserByEmail("van@gmail.COM")).contains(user1);
        assertThat(userRepo.findUserByEmail("nam@gmail.com")).isNotPresent();
    }
}
