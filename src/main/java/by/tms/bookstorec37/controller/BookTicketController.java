package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.*;
import by.tms.bookstorec37.service.AuthorService;
import by.tms.bookstorec37.service.BasketService;
import by.tms.bookstorec37.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping({"/book", "/order"})
public class BookTicketController {

    @Autowired
    BasketService basketService;

    @Autowired
    TempBasketList tempBasketList;

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping(path = "/bookTicket/{bookId}")
    public ModelAndView showBookTicket (@PathVariable Long bookId,
                                        ModelAndView modelAndView,
                                        HttpSession httpSession) {
        Book bookForBasket = bookService.getBookById(bookId);
        modelAndView.addObject("bookForBasket", bookForBasket);
        modelAndView.setViewName("/book/bookTicket");
        return modelAndView;
    }

    @PostMapping(path = "/bookTicket/{bookId}")
        public ModelAndView putBookToBasket (@PathVariable Long bookId,
                                             ModelAndView modelAndView,
                                             HttpSession httpSession) {
        Book bookForBasket = bookService.getBookById(bookId);
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
        if (!basketService.isBookExistInBasket(userBasket.getBookSet(), bookForBasket)) {
            userBasket.getBookSet().add(bookForBasket);
            modelAndView.addObject("addedBookToBasketMessage", "book "
                    + bookForBasket.getName() + " added");
        } else {
            modelAndView.addObject("bookAlreadyAdded", "Книга "
                                                 + bookForBasket.getName()
                                                 + " уже добавлена в корзину");
        }
        modelAndView.addObject("bookForBasket", bookForBasket);
        modelAndView.setViewName("/book/bookTicket");
        return modelAndView;
    }
}