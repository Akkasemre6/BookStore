package Service.business;

import Entity.User.User;
import Entity.business.Book;
import Entity.business.Order;
import Payload.Mapper.Business.OrderMapper;
import Payload.Response.Business.OrderResponse;
import Repository.business.BookRepository;
import Repository.business.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;


    public ResponseEntity<List<OrderResponse>> getAllOrder() {
            List<Order> orders= orderRepository.findAll();
            List<OrderResponse> responses = orders.stream().map(OrderMapper::mapOrderToOrderResponse).toList();
            return ResponseEntity.ok(responses);
    }

   @Transactional
    public Order createOrder(User user, List<OrderItemRequest> orders) {}


}
