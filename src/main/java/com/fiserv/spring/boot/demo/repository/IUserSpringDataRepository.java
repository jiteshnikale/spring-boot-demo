package com.fiserv.spring.boot.demo.repository;

import com.fiserv.spring.boot.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserSpringDataRepository extends JpaRepository<User, Long> {
}
