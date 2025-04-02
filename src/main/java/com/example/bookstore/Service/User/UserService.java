package com.example.bookstore.Service.User;



import com.example.bookstore.Entity.User.User;

import com.example.bookstore.Payload.Mapper.User.UserMapper;
import com.example.bookstore.Payload.Messages.ErrorMessages;
import com.example.bookstore.Payload.Messages.SuccessMessages;
import com.example.bookstore.Payload.Request.User.UserCreateRequest;
import com.example.bookstore.Payload.Request.User.UserUpdateRequest;
import com.example.bookstore.Payload.Response.Business.ResponseMessage;
import com.example.bookstore.Payload.Response.User.UserResponse;
import com.example.bookstore.Repository.User.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseMessage<UserResponse> createUser(UserCreateRequest userCreateRequest, HttpServletRequest servletRequest) {

        User newUser = new User();
        newUser.setName(userCreateRequest.getName());
        newUser.setPassword(userCreateRequest.getPassword());
        newUser.setEmail(userCreateRequest.getEmail());
        newUser.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(newUser);
        UserResponse response = userMapper.mapUserToUserResponse(savedUser);

        return ResponseMessage.<UserResponse>builder()
                .message(SuccessMessages.USER_CREATED_SUCCESSFULLY)
                .object(response).build();
    }


    public ResponseEntity<UserResponse> getUserById(long id) {

        if (userRepository.existsById(id)) {
            User user = userRepository.getUserById(id);
            return ResponseEntity.ok(userMapper.mapUserToUserResponse(user));
        }
        return ResponseEntity.notFound().build();
    }


    public ResponseMessage<UserResponse> updateUser(UserUpdateRequest request, long id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getUserById(id);
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            User savedUser = userRepository.save(user);
            UserResponse response = userMapper.mapUserToUserResponse(savedUser);
            return ResponseMessage.<UserResponse>builder()
                    .message(SuccessMessages.USER_UPDATED_SUCCESSFULLY)
                    .object(response).build();
        }
        return ResponseMessage.<UserResponse>builder()
                .message(ErrorMessages.USER_NOT_FOUND)
                .build();
    }


    public String deleteById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return SuccessMessages.USER_DELETED_SUCCESSFULLY;
        }
        return ErrorMessages.USER_NOT_FOUND;
    }

    public Boolean getAll() {
        if (userRepository.findAll().isEmpty()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void createFirstUser(User user) {
        userRepository.save(user);
    }
}
