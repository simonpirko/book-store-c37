package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServise {

    BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public void deleteBookByName(String name){
        bookRepository.deleteBookByName;
    }

    public boolean existBookById(Long id){
        return bookRepository.existsById(id);
    }

    public Book getBookById(long id) {
        return bookRepository.getOne(id);
    }

    public Book getBookByName(String name){
        return bookRepository.getBookByName(name);
    }

    public void editBookDescription(String name, String description){
        Book bookToUpdateDescription = bookRepository.getBookByName(name);
        bookToUpdateDescription.setDescription(description);
        bookRepository.save(bookToUpdateDescription);
    }

    public void editBookPrice(String name, double price) {
        Book bookToUpdatePrice = bookRepository.getBookByName(name);
        bookToUpdatePrice.setPrice(price);
        bookRepository.save(bookToUpdatePrice);
    }

}
