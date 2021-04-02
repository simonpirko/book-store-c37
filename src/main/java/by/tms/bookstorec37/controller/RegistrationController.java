package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.User;
import by.tms.bookstorec37.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        modelAndView.addObject("ModelAttribute", new User());
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegPage(@ModelAttribute("ModelAttribute")User user, ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        if(!userService.isUserExistByUserName(user.getUsername())){
            userService.addUser(user);
            modelAndView.setViewName("redirect:/user/auth");
        } else {
            modelAndView.addObject("userIsExistsError", "User with this " +
                    " username is already exists!");
        }   return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView){
        modelAndView.setViewName("auth");
        return modelAndView;
    }
}
