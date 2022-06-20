package vn.techmaster.usermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.usermanagement.model.State;
import vn.techmaster.usermanagement.model.User;
import vn.techmaster.usermanagement.repository.UserRepo;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TestUserRepo {
    @Test
    void addUser() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Nguyen Van", "van@gmail.com", "123", State.ACTIVE);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getState()).isEqualTo(State.ACTIVE);
    }

    @Test
    void addPendingUser() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addPendingUser("Nguyen Van", "van@gmail.com", "123");
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
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
        assertThat(userRepo.findUserByEmail("NGoc@gmail.COM")).contains(user2);
        assertThat(userRepo.findUserByEmail("SoN@gmail.coM")).contains(user3);
        assertThat(userRepo.findUserByEmail("nam@gmail.com")).isNotPresent();
    }
}
