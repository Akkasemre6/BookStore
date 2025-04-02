package com.example.bookstore.Payload.Mapper.User;


import com.example.bookstore.Entity.User.User;
import com.example.bookstore.Payload.Response.User.UserResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserResponse mapUserToUserResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public User mapUserResponseToUser(UserResponse userResponse) {
        return User.builder()
                .id(userResponse.getId())
                .name(userResponse.getName())
                .password(userResponse.getPassword())
                .email(userResponse.getEmail())
                .createdAt(userResponse.getCreatedAt())
                .build();
    }


}
