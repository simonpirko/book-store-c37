package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/book")
public class testController {

    @GetMapping(path = "/test")
    public ModelAndView modelAndView (@ModelAttribute Basket bbb,
                                      ModelAndView modelAndView) {
        modelAndView.setViewName("/book/test");
        return modelAndView;
    }


    @PostMapping(path = "/test")
    public ModelAndView modelAndViewPost (@ModelAttribute("bbb") Basket bbb,
                                          ModelAndView modelAndView) {
        modelAndView.setViewName("/book/test");
        return modelAndView;
    }
}
