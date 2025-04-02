package com.example.bookstore.Payload.Request.business;

import lombok.Data;

@Data
public class OrderItemRequest {


    private long bookId;
    private Integer quantity;

}
