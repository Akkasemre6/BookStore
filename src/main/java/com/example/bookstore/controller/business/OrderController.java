package controller.business;

import Entity.User.User;
import Entity.business.Order;
import Payload.Request.business.OrderCreateRequest;
import Payload.Request.business.OrderRequest;
import Payload.Response.Business.OrderResponse;
import Service.business.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder
            (@RequestBody OrderCreateRequest request) {
         return orderService.createOrder(request);

    }

    @GetMapping(path = "/{orderId}")
    private ResponseEntity<OrderResponse> getOrderById(@PathVariable long orderId){
        return orderService.getOrderById(orderId);
    }




}
