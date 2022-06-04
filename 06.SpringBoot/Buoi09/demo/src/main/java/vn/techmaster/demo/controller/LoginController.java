package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.techmaster.demo.request.UserLoginRequest;
import vn.techmaster.demo.request.UserLoginResponse;
import vn.techmaster.demo.service.LoginService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping()
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return loginService.login(request);
    }
}
