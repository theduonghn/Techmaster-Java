package vn.techmaster.usermanagement;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.usermanagement.exception.UserException;
import vn.techmaster.usermanagement.hash.Hashing;
import vn.techmaster.usermanagement.model.State;
import vn.techmaster.usermanagement.model.User;
import vn.techmaster.usermanagement.service.UserService;

@SpringBootTest
class TestUserService {
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
        assertThat(user.getState()).isEqualTo(State.PENDING);

    }

    @Test
    void addActiveUser() {
        User user = userService.addActiveUser("Nguyen Van Nam", "nam@gmail.com", "123");
        assertThat(user).isNotNull();
        assertThat(user.getFullName()).isEqualTo("Nguyen Van Nam");
        assertThat(user.getEmail()).isEqualTo("nam@gmail.com");
        assertThat(hashing.validatePassword("123", user.getHashedPassword())).isTrue();
        assertThat(user.getState()).isEqualTo(State.ACTIVE);
    }

    @Test
    void loginWhenAccountIsPending() {
        userService.addUser("Nguyen Van Nam", "nam@gmail.com", "123");
        assertThatThrownBy(() -> {
            userService.login("nam@gmail.com", "123");
        }).isInstanceOf(UserException.class).hasMessage("User is not activated");
    }

    @Test
    void loginWhenAccountIsNotFound() {
        assertThatThrownBy(() -> {
            userService.login("nam@gmail.com", "123");
        }).isInstanceOf(UserException.class).hasMessage("User is not found");
    }

    @Test
    void loginWhenPasswordIsIncorrect() {
        userService.addActiveUser("Nguyen Van Nam", "nam@gmail.com", "123");
        assertThatThrownBy(() -> {
            userService.login("nam@gmail.com", "123_");
        }).isInstanceOf(UserException.class).hasMessage("Password is incorrect");
    }

    @Test
    void loginSuccess() {
        userService.addActiveUser("Nguyen Van Nam", "nam@gmail.com", "123");
        assertThat(userService.login("nam@gmail.com", "123")).isNotNull();
    }
}
