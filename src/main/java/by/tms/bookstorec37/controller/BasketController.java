package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Basket;
import by.tms.bookstorec37.service.BasketService;
import by.tms.bookstorec37.service.OrderService;
import by.tms.bookstorec37.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/order")
public class BasketController {

    @Autowired
    BasketService basketService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/basket")
    public ModelAndView showBasket (
//                                  @PathVariable long userId,
                                    ModelAndView modelAndView,
                                    HttpSession httpSession) {
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
        modelAndView.addObject("userBasket", userBasket);
        modelAndView.setViewName("/order/basket");
        return modelAndView;
    }

}
