package com.fiserv.spring.boot.demo.controller;

import com.fiserv.spring.boot.demo.exception.ResourceNotFoundException;
import com.fiserv.spring.boot.demo.models.User;
import com.fiserv.spring.boot.demo.service.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private IUserService userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);

        if(user == null) {
            throw new ResourceNotFoundException("User not found for the Id: " + id);
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {

        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                        .buildAndExpand(user.getId()).toUri();
        headers.add("location", location.toString());
        ResponseEntity<Object> response = new ResponseEntity<>(null, headers, HttpStatus.CREATED);
        return response;
    }
}
