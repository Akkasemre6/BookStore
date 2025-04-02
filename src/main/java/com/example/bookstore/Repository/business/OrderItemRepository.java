package com.example.bookstore.Repository.business;


import com.example.bookstore.Entity.business.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
