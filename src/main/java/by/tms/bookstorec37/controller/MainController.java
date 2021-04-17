package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Basket;
import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.entity.User;
import by.tms.bookstorec37.service.AuthorService;
import by.tms.bookstorec37.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(path="/")
public class MainController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @GetMapping
    public ModelAndView modelAndViewShowMain (ModelAndView modelAndView,
                                              HttpSession httpSession) {
        httpSession.setAttribute("currentUser", new User(1,"test", "test"));
        User currentUser = (User) httpSession.getAttribute("currentUser");
        Basket userBasket = new Basket();
        Set<Book> bookSet = new HashSet<>();
        userBasket.setBookSet(bookSet);
        userBasket.setUserId(currentUser.getId());
        userBasket.setId(1);
        httpSession.setAttribute("userBasket", userBasket);
        modelAndView.setViewName("main");
        authorService.addAuthorListToDataBase();
        bookService.addBooksToDataBase();
        return modelAndView;
    }

    @GetMapping(path = "/userCabinet")
    public ModelAndView modelAndViewUserCabinetGet (ModelAndView modelAndView) {
        modelAndView.setViewName("userCabinet");
        return modelAndView;
    }

    @GetMapping(path = "/adminCabinet")
    public ModelAndView modelAndViewAdminCabinetGet (ModelAndView modelAndView) {
        modelAndView.setViewName("adminCabinet");
        return modelAndView;
    }

    @GetMapping(path = "/managerCabinet")
    public ModelAndView modelAndViewManagerCabinetGet (ModelAndView modelAndView) {
        modelAndView.setViewName("managerCabinet");
        return modelAndView;
    }

}
