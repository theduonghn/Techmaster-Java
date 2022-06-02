package vn.techmaster.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String avatar;
}
