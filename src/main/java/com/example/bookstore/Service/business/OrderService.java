package com.example.bookstore.Service.business;


import com.example.bookstore.Entity.business.Book;
import com.example.bookstore.Entity.business.Order;
import com.example.bookstore.Entity.business.OrderItem;
import com.example.bookstore.Payload.Mapper.Business.OrderMapper;
import com.example.bookstore.Payload.Request.business.OrderCreateRequest;
import com.example.bookstore.Payload.Response.Business.OrderResponse;
import com.example.bookstore.Repository.User.UserRepository;
import com.example.bookstore.Repository.business.BookRepository;
import com.example.bookstore.Repository.business.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ResponseEntity<OrderResponse> createOrder(OrderCreateRequest request) {
        Order order = new Order();
        order.setUser(userRepository.findById(request.getUserId()).orElseThrow());
        List<OrderItem> items = request.getItems().stream()
                .map(item -> {
                    Book book = bookRepository.findById(item.getBookId()).orElseThrow();
                    OrderItem orderItem = new OrderItem();
                    orderItem.setBook(book);
                    orderItem.setQuantity(item.getQuantity());
                    return orderItem;
                }).toList();
        order.setItems(items);
        order.calculateTotalPrice();
        orderRepository.save(order);
        return ResponseEntity.ok(OrderMapper.mapOrderToOrderResponse(order));
    }

    public ResponseEntity<OrderResponse> getOrderById(long orderId) {

        if (orderRepository.existsById(orderId)) {
            Order order = orderRepository.findById(orderId).orElseThrow();
            return ResponseEntity.ok(OrderMapper.mapOrderToOrderResponse(order));
        }
        return ResponseEntity.notFound().build();
    }
}
