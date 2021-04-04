package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.service.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException userNotFoundException, Model model) {
        model.addAttribute("message", userNotFoundException.getMessage());
        return "errorPage";
    }
}
