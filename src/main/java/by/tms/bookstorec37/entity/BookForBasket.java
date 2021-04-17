package by.tms.bookstorec37.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForBasket {

    private Book book;
    private long userId;
    private long basketId;

    public BookForBasket(Book book, long userId) {
        this.book = book;
        this.userId = userId;
    }
}
