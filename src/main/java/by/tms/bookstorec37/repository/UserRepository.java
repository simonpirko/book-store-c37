package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
