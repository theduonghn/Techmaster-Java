package vn.techmaster.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.techmaster.security.entity.User;
import vn.techmaster.security.repository.UserRepository;

import java.util.List;

@SpringBootTest
public class CreateUserTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void save_users() {
        User user1 = User.builder()
                .name("Nguyễn Văn A")
                .email("a@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role(List.of("USER", "EDITOR", "ADMIN"))
                .build();

        User user2 = User.builder()
                .name("Trần Văn B")
                .email("b@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role(List.of("USER", "EDITOR"))
                .build();

        User user3 = User.builder()
                .name("Ngô Thị C")
                .email("c@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role(List.of("USER"))
                .build();

        userRepository.saveAll(List.of(user1, user2, user3));
    }
}
