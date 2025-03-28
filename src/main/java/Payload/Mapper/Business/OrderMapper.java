package Payload.Mapper.Business;

import Entity.business.Order;
import Payload.Response.Business.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OrderMapper {

    public static OrderResponse mapOrderToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .items(order.getItems().stream().map(OrderItemMapper::mapOrderItemToOrderItemResponse).toList())
                .build();
    }


}
