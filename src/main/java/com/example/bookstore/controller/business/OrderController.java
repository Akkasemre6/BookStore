package com.example.bookstore.controller.business;


import com.example.bookstore.Payload.Request.business.OrderCreateRequest;
import com.example.bookstore.Payload.Response.Business.OrderResponse;
import com.example.bookstore.Service.business.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<OrderResponse> getOrderById(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }


}
