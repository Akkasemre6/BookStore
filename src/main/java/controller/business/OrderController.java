package controller.business;

import Entity.User.User;
import Entity.business.Order;
import Payload.Request.business.OrderRequest;
import Payload.Response.Business.OrderResponse;
import Service.business.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "/getAllOrder")
    ResponseEntity<List<OrderResponse>>  getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody OrderRequest request,
            @AuthenticationPrincipal User user
            ){
        return orderService.createOrder(user,request.getItems());

    }




}
