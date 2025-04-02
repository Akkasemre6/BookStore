package com.example.bookstore.Payload.Request.business;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequest {

    private long userId;
    private List<OrderItemRequest> items;

}
