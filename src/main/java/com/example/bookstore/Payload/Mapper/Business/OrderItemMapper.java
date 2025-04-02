package Payload.Mapper.Business;

import Entity.business.OrderItem;
import Payload.Response.Business.OrderItemResponse;



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
