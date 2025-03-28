package Payload.Mapper.Business;

import Entity.business.Order;
import Payload.Response.Business.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OrderMapper {

    public static Order mapOrderResponseToOrder(OrderResponse orderResponse) {
        return Order.builder()
                .user(orderResponse.getUser())
                .price(orderResponse.getPrice())
                .order(orderResponse.getOrder())
                .build();
    }

    public static OrderResponse mapOrderToOrderResponse(Order order){
        return OrderResponse.builder()
                .user(order.getUser())
                .price(order.getPrice())
                .build();
    }

}
