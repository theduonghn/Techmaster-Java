package vn.techmaster.usermanagement.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import vn.techmaster.usermanagement.exception.UserException;

@ControllerAdvice
public class HandleExceptionController {
    @ExceptionHandler(UserException.class)
    public String handleUserException(UserException exception, Model model) {
        model.addAttribute("error", exception);
        return "error";
    }
}
