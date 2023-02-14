package com.fiserv.spring.boot.demo.controller;

import com.fiserv.spring.boot.demo.exception.ResourceNotFoundException;
import com.fiserv.spring.boot.demo.models.Post;
import com.fiserv.spring.boot.demo.models.User;
import com.fiserv.spring.boot.demo.service.IUserService;
import com.fiserv.spring.boot.demo.service.UserJPAService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserJPAController {

    private IUserService userService;
    public UserJPAController(UserJPAService userService) {
        this.userService = userService;
    }
    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/jpa/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUser(id);

        if(user == null) {
            throw new ResourceNotFoundException("User not found for the Id: " + id);
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {

        User savedUser = userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        headers.add("location", location.toString());
        ResponseEntity<Object> response = new ResponseEntity<>(null, headers, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable long id) {
        User user = userService.getUser(id);

        if(user == null) {
            throw new ResourceNotFoundException("User not found for the Id: " + id);
        }

        return ResponseEntity.ok(user.getPosts());
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> saveUserPosts(@PathVariable long id, @RequestBody Post post) {
        User user = userService.getUser(id);

        if(user == null) {
            throw new ResourceNotFoundException("User not found for the Id: " + id);
        }

        post.setUser(user);
        Post savePost = userService.saveUserPost(post);
        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId()).toUri();
        headers.add("location", location.toString());
        ResponseEntity<Object> response = new ResponseEntity<>(null, headers, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public ResponseEntity<Post> getUserPost(@PathVariable long userId, @PathVariable long postId) {
        User user = userService.getUser(userId);

        if(user == null) {
            throw new ResourceNotFoundException("User not found for the Id: " + userId);
        }

        Post post = user.getPosts().stream().filter(x -> x.getId() == postId).findFirst().orElse(null);

        if(post == null) {
            throw new ResourceNotFoundException(String.format("Post id %d not found for User id %s", postId, userId));
        }

        return ResponseEntity.ok(post);
    }
}
