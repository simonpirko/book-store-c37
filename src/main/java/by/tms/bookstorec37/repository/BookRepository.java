package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteBookByName(String Name);
    Book getBookByName(String name);
}
