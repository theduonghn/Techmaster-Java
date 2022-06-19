package com.techmaster.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import com.techmaster.login.hash.Hashing;
import com.techmaster.login.model.User;
import com.techmaster.login.service.UserService;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;
    @Autowired
    private Hashing hashing;

    @Test
    void addUser() {
        User user = userService.addUser("Nguyen Van Nam", "nam@gmail.com", "123");
        assertThat(user).isNotNull();
        assertThat(user.getFullName()).isEqualTo("Nguyen Van Nam");
        assertThat(user.getEmail()).isEqualTo("nam@gmail.com");
        assertThat(hashing.validatePassword("123", user.getHashedPassword())).isTrue();
    }
}
