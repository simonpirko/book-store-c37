package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
