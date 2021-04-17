package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.entity.Order;
import by.tms.bookstorec37.entity.User;
import by.tms.bookstorec37.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(path = {"/order", "/user", "/"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/newOrder")
    public ModelAndView newOrderPage (@ModelAttribute("ModelAttribute") Order order,
                                      ModelAndView modelAndView) {
        modelAndView.setViewName("/order/newOrder");
        return modelAndView;
    }

    @PostMapping(path = "/newOrder")
    public ModelAndView createNewOrder (@ModelAttribute("ModelAttribute") Order order,
                                        ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/userCabinet");
        orderService.addNewOrder(order);
        return modelAndView;
    }
}