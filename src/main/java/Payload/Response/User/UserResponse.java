package Payload.Response.User;

import Entity.business.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponse {

    private long id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private Order order;



}
