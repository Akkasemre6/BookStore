package com.example.bookstore.Payload.Mapper.Business;


import com.example.bookstore.Entity.business.Order;
import com.example.bookstore.Payload.Response.Business.OrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {

    public static OrderResponse mapOrderToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .items(order.getItems().stream().map(OrderItemMapper::mapOrderItemToOrderItemResponse).toList())
                .build();
    }


}
