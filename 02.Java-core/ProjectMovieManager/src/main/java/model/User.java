package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

import java.util.UUID;

@Getter
@Setter
@ToString
public class User {
    private UUID id;
    private String email;
    private String password;
    private UserRole role;

    public User(String email, String password, UserRole role) {
        this.id = Util.generateId();
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
