package com.example.bookstore.Payload.Response.Business;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItemResponse {


    private long bookId;
    private String bookTitle;
    private double bookPrice;
    private Integer quantity;

}
