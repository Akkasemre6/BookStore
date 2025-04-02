package com.example.bookstore.Repository.business;


import com.example.bookstore.Entity.business.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
