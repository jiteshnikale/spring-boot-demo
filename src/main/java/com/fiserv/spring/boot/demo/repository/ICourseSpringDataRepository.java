package com.fiserv.spring.boot.demo.repository;

import com.fiserv.spring.boot.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
