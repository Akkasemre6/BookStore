package Payload.Response.Business;

import Entity.User.User;
import Entity.business.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {


    @NotNull
    private long bookId;


    private Integer quantity;

}
