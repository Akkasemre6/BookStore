package com.example.bookstore.Payload.Response.Business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {


    private long id;
    private double totalPrice;
    private List<OrderItemResponse> items;


}
