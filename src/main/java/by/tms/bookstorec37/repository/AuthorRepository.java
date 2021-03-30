package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
