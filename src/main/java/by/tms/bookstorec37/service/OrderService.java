package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.*;
import by.tms.bookstorec37.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public void addNewOrder (Order order) {
        orderRepository.save(order);
    }

    public void deleteOrderById (long id) {
        orderRepository.deleteById(id);
    }

    public void deleteAllOrdersByUser (User user) {
        orderRepository.deleteOrdersByUser (user);
    }

    public void deleteAllOrdersByStatus (OrderStatus orderStatus) {
        orderRepository.deleteOrdersByOrderStatus(orderStatus);
    }

    public Order findOrderById (long id) {
        return orderRepository.getOne(id);
    }

    public List<Order> findAllOrdersByUser (User user) {
        return orderRepository.findOrdersByUser(user);
    }

    public List<Order> findAllOrdersByStatus (OrderStatus orderStatus) {
        return orderRepository.findOrdersByOrderStatus (orderStatus);
    }

    public List<Order> findAllOrdersByBook (Book book) {
        return orderRepository.findOrdersByBookListIsContaining(book);
    }

    public void updateOrderStatusById (long id, OrderStatus newOrderStatus) {
        orderRepository.getOne(id).setOrderStatus(newOrderStatus);
    }

    public void removeBookFromOrderById (long id, Book book) {
        orderRepository.getOne(id).getBookList().remove(book);
    }

    public void changeUserInOrderById (long id, User newUser) {
        orderRepository.getOne(id).setUser(newUser);
    }

    public List<Order> findAllOrders () {
        return orderRepository.findAll();
    }

}
