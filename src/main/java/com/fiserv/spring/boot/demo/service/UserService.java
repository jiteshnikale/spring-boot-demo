package com.fiserv.spring.boot.demo.service;

import com.fiserv.spring.boot.demo.models.Post;
import com.fiserv.spring.boot.demo.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements IUserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jitesh Nikale", LocalDate.now().minusYears(38)));
        users.add(new User(2, "Vishal Borade", LocalDate.now().minusYears(35)));
        users.add(new User(3, "Pratik Dedhia", LocalDate.now().minusYears(36)));
    }
    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public User saveUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    @Override
    public Post saveUserPost(Post post) {
        return null;
    }
}
