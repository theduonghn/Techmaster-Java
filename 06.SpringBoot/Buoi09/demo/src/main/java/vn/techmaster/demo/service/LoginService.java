package vn.techmaster.demo.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import vn.techmaster.demo.exception.LoginFailedException;
import vn.techmaster.demo.repository.UserRepository;
import vn.techmaster.demo.request.UserLoginRequest;
import vn.techmaster.demo.request.UserLoginResponse;

@Service
@AllArgsConstructor
public class LoginService {
    private UserRepository userRepository;

    public UserLoginResponse login(UserLoginRequest loginRequest) {
        UserLoginResponse userInfo = userRepository.login(loginRequest);
        if (userInfo == null) {
            throw new LoginFailedException("username hoặc password chưa chính xác");
        } else {
            return userInfo;
        }
    }
}
