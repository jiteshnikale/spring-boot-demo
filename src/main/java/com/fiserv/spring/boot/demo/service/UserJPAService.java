package com.fiserv.spring.boot.demo.service;

import com.fiserv.spring.boot.demo.models.Post;
import com.fiserv.spring.boot.demo.models.User;
import com.fiserv.spring.boot.demo.repository.IPostSpringDataRepository;
import com.fiserv.spring.boot.demo.repository.IUserSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
UserJPAService implements IUserService {

    @Autowired
    private IUserSpringDataRepository repository;

    @Autowired
    private IPostSpringDataRepository postRepository;
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public Post saveUserPost(Post post) {
        return postRepository.save(post);
    }
}
