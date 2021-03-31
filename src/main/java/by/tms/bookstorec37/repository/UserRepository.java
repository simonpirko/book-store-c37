package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.callback.PasswordCallback;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUsername(String username);
    void deleteUserByUsername(String username);
    User getUserByUsername(String username);
    User getUserById(long id);
}
