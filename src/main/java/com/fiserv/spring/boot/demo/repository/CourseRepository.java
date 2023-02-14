package com.fiserv.spring.boot.demo.repository;

import com.fiserv.spring.boot.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Course course) {
        jdbcTemplate.update("Insert into course (id, name, author) values (?, ? , ?)",
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update("Delete From Course where id = ?", id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject("Select * from Course where id = ?", new BeanPropertyRowMapper<Course>(Course.class), id);
    }
}
