package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Basket;
import by.tms.bookstorec37.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketRepository extends JpaRepository <Basket, Long> {
    List<Basket> findAllByUserId(long id);
    Basket getByUserId(long userId);
    Basket findByUserId(long userId);
    boolean existsByUserId(long userId);
    void deleteByUserId(long userId);

}
