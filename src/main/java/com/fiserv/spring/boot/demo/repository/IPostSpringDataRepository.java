package com.fiserv.spring.boot.demo.repository;

import com.fiserv.spring.boot.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostSpringDataRepository extends JpaRepository<Post, Long> {
}
