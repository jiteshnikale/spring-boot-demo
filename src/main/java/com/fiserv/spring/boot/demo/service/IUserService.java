package com.fiserv.spring.boot.demo.service;

import com.fiserv.spring.boot.demo.models.Post;
import com.fiserv.spring.boot.demo.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUser(long id);

    User saveUser(User user);

    Post saveUserPost(Post post);

}
