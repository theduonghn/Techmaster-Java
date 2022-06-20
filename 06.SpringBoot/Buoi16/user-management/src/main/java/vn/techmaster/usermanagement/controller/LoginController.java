package vn.techmaster.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.usermanagement.exception.UserException;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("foo")
    public String foo() {
        throw new UserException("Some error");
    }
}
