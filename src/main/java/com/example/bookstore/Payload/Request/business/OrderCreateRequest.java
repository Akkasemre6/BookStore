package Payload.Request.business;

import Payload.Response.Business.OrderItemResponse;
import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequest {

    private long userId;
    private List<OrderItemRequest> items;

}
