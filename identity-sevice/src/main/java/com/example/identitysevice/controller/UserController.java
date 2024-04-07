package com.example.identitysevice.controller;

import com.example.identitysevice.Service.UserService;
import com.example.identitysevice.dto.request.UserCreationRequest;
import com.example.identitysevice.dto.request.UserUpdateRequest;
import com.example.identitysevice.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping()
    List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUsers(@PathVariable("userId") String userId) {
        return userService.getUserId(userId);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
return  userService.updateUser(userId,request);
    }
    @DeleteMapping("/{userId}")
    String deleteUsers(@PathVariable String userId) {
       userService.deleteUser(userId);
        return "User has been deleted";
    }
}
