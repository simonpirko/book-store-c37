package by.tms.bookstorec37.repository;

import by.tms.bookstorec37.entity.Book;
import by.tms.bookstorec37.entity.Order;
import by.tms.bookstorec37.entity.OrderStatus;
import by.tms.bookstorec37.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByUser(User user);
    List<Order> findOrdersByOrderStatus(OrderStatus orderstatus);
    List<Order> findOrdersByBookListIsContaining(Book book);
    void deleteOrdersByUser(User user);
    void deleteOrdersByOrderStatus (OrderStatus orderstatus);
}

