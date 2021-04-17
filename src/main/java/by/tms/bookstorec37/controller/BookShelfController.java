package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Basket;
//import by.tms.bookstorec37.service.BasketService;
import by.tms.bookstorec37.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class BookShelfController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/bookShelf")
    public ModelAndView showBookShelfPage (ModelAndView modelAndView) {
        modelAndView.addObject("tempBooks", bookService.getAllBooks());
        modelAndView.setViewName("order/bookShelf");
        modelAndView.addObject("size", bookService.getAllBooks().size() + 1);
        return modelAndView;
    }

}