package by.tms.bookstorec37.controller;

import by.tms.bookstorec37.entity.Basket;
import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.service.BasketService;
import by.tms.bookstorec37.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/book")
public class RemoveBookFromBasketController {

    @Autowired
    BookService bookService;

    @PostMapping(path = "/removeBookFromBasket/{bookId}")
    public ModelAndView removeBookFromBasket (
//                                              @ModelAttribute("bookToRemoveFromBasket") Book book,
                                              @PathVariable long bookId,
                                              ModelAndView modelAndView,
                                              HttpSession httpSession) {
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
//          Book bookByName = bookService.getBookByName(book.getName());
        ((Basket) httpSession.getAttribute("userBasket")).getBookSet().remove(bookService.getBookById(bookId));
//        ((Basket) httpSession.getAttribute("userBasket")).getBookSet().remove(bookByName);
        modelAndView.addObject("userBasket", httpSession.getAttribute("userBasket"));
        modelAndView.setViewName("/order/basket");
        return modelAndView;
    }
}
