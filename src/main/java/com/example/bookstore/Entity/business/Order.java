package com.example.bookstore.Entity.business;


import com.example.bookstore.Entity.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    private double totalPrice;

    public void calculateTotalPrice() {
        this.totalPrice = items.stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity()).sum();
    }


}
