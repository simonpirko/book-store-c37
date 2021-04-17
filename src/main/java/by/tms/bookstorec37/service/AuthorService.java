package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.Author;
import by.tms.bookstorec37.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addNewAuthor (Author author) {
        authorRepository.save(author);
    }

    public void addAuthorListToDataBase () {
        addNewAuthor(new Author(1, "Clifford Donald", "Simak"));
        addNewAuthor(new Author(2, "Arthur", "Conan Doyle"));
        addNewAuthor(new Author(3, "William", "Shakespeare"));
        addNewAuthor(new Author(4, "Рафаэль", "Саббатини"));
        addNewAuthor(new Author(5, "Джанни", "Родари"));
        addNewAuthor(new Author(6, "Александр", "Дюма"));
        addNewAuthor(new Author(7, "Братья", "Стругацкие"));
        addNewAuthor(new Author(8, "Александр", "Пушкин"));
        addNewAuthor(new Author(9, "Братья", "Вайнеры"));
        addNewAuthor(new Author(10, "Агата", "Кристи"));
        addNewAuthor(new Author(11, "Юлиан", "Семенов"));
    }

    public Author getAuthorById (long id) {
        return authorRepository.getOne(id);
    }
}
