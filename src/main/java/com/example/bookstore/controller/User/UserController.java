package com.example.bookstore.controller.User;



import com.example.bookstore.Payload.Request.User.UserCreateRequest;
import com.example.bookstore.Payload.Request.User.UserUpdateRequest;
import com.example.bookstore.Payload.Response.Business.ResponseMessage;
import com.example.bookstore.Payload.Response.User.UserResponse;

import com.example.bookstore.Service.User.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/User")
@RequiredArgsConstructor


public class UserController {

    private final UserService userService;
    //TODO: CRUD Controller

    @PostMapping(path = "/createUser")
    public ResponseMessage<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest, HttpServletRequest servletRequest) {
        return userService.createUser(userCreateRequest, servletRequest);
    }


    @GetMapping(path = "/getUserById/{id}")
    public ResponseEntity<UserResponse> getUserById(long id) {
        return userService.getUserById(id);
    }

    @PatchMapping(path = "/updateUser/{id}")
    public ResponseMessage<UserResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, long id) {
        return userService.updateUser(userUpdateRequest, id);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public String deleteById(long id) {
        return userService.deleteById(id);
    }


}
