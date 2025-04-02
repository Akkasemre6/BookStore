package com.example.bookstore.Payload.Mapper.Business;


import com.example.bookstore.Entity.business.OrderItem;
import com.example.bookstore.Payload.Response.Business.OrderItemResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public static OrderItemResponse mapOrderItemToOrderItemResponse(OrderItem orderItem) {

        return OrderItemResponse.builder()
                .bookId(orderItem.getId())
                .bookTitle(orderItem.getBook().getBookName())
                .bookPrice(orderItem.getBook().getPrice())
                .quantity(orderItem.getQuantity())
                .build();

    }
}
