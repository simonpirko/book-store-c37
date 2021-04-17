package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BasketService {

    public boolean isBookExistInBasket (Set<Book> bookSet, Book book) {
        for (Book bookInBasketSet : bookSet
             ) {
            return bookInBasketSet.equals(book);
        }
        return false;
    }


}