package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Category, Long> {
}
