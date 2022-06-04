package vn.techmaster.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserLoginResponse {
    private String username;
    private String email;
    private String avatar;
}
