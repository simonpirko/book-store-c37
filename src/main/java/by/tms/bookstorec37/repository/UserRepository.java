package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.User;
import com.zaxxer.hikari.util.ClockSource;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUsername(String username);
    User getUserById(long id);
    boolean existsUserByUsername(String username);
    void deleteUserByUsername(String username);
}
