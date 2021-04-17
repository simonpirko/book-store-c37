package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public void deleteBookByName(String name){
        bookRepository.deleteBookByName(name);
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

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    public void addBooksToDataBase () {

        addBook(new Book(1, "Витки", "Fantastic", authorService.getAuthorById(1), 25));
        addBook(new Book(2, "Шерлок Холмс", "Adventure", authorService.getAuthorById(2), 30));
        addBook(new Book(3, "Гамлет", "Drama", authorService.getAuthorById(3), 15));
        addBook(new Book(4, "Одиссея капитана Блада", "Adventure", authorService.getAuthorById(4), 17));
        addBook(new Book(5, "Приключения Буратино", "Детская", authorService.getAuthorById(5), 8));
        addBook(new Book(6, "Сонеты", "Стихи", authorService.getAuthorById(3), 15));
        addBook(new Book(7, "Хроника капитана Блага", "Приключения", authorService.getAuthorById(4), 15));
        addBook(new Book(8, "Три мушкетера", "Роман", authorService.getAuthorById(6), 9));
        addBook(new Book(9, "Двадцать лет спустя", "Роман", authorService.getAuthorById(6), 11));
        addBook(new Book(10, "Тридцать лет спустя", "Роман", authorService.getAuthorById(6), 12));
        addBook(new Book(11, "Понедельник начинается в субботу", "Фантастика", authorService.getAuthorById(7), 15));
        addBook(new Book(12, "Трудно быть богом", "Фантастика", authorService.getAuthorById(7), 25));
        addBook(new Book(13, "Капитанская дочка", "Повесть", authorService.getAuthorById(8), 11));
        addBook(new Book(14, "Евгений Онегин", "Поэма", authorService.getAuthorById(8), 21));
        addBook(new Book(15, "Эра милосердия", "Детектив", authorService.getAuthorById(9), 40));
        addBook(new Book(16, "Сборник детективов", "Детектив", authorService.getAuthorById(10), 99));
        addBook(new Book(17, "Тасс уполномочен заявить", "Шпионский детектив", authorService.getAuthorById(11), 50));
        addBook(new Book(18, "Бриллианты для диктатуры пролетариата", "Шпионский детектив", authorService.getAuthorById(11), 55));

    }
}
