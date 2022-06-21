package vn.techmaster.usermanagement.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.usermanagement.exception.UserException;
import vn.techmaster.usermanagement.request.LoginRequest;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("loginRequest", new LoginRequest("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@Valid @ModelAttribute LoginRequest loginRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/foo")
    public String foo() {
        throw new UserException("Some error");
    }
}
