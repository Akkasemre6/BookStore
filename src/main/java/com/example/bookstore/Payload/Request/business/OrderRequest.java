package com.example.bookstore.Payload.Request.business;



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
    private List<com.example.bookstore.Payload.Response.Business.OrderItemResponse> items;


}




