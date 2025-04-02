package Payload.Response.Business;

import Entity.User.User;
import Entity.business.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {


    private long id;
    private double totalPrice;
    private List<OrderItemResponse> items;


}
