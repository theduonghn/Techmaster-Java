package com.techmaster.login;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import com.techmaster.login.hash.Hashing;

@SpringBootTest
class TestHash {
    @Autowired
    private Hashing hashing;

    @Test
    void hashPassword() {
        List<String> passwords = List.of("abc", "123", "gawM");
        for (String password : passwords) {
            String hashedPassword = hashing.hashPassword(password);
            assertThat(hashedPassword).isNotNull();
        }
    }

    @Test
    void validatePassword() {
        List<String> passwords = List.of("abc", "123", "gawM");
        for (String password : passwords) {
            String hashedPassword = hashing.hashPassword(password);
            assertThat(hashing.validatePassword(password, hashedPassword)).isTrue();
        }

        assertThat(hashing.validatePassword("abC", hashing.hashPassword("abc"))).isFalse();
    }

}
