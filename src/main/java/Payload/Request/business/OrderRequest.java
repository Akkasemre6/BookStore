package Payload.Request.business;

import Payload.Response.Business.OrderItemResponse;
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

public class OrderRequest {


    @NotNull
    private List<OrderItemResponse> items;


}




