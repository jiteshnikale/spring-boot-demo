package com.fiserv.spring.boot.demo.commandline;

import com.fiserv.spring.boot.demo.models.Course;
import com.fiserv.spring.boot.demo.repository.CourseJPARepository;
import com.fiserv.spring.boot.demo.repository.CourseRepository;
import com.fiserv.spring.boot.demo.repository.ICourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    /*@Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseJPARepository courseJPARepository;*/

    @Autowired
    private ICourseSpringDataRepository courseSpringDataRepository;

    @Override
    public void run(String... args) throws Exception {
        /*courseRepository.insert(new Course(1, "Learn Azure", "Jitesh Nikale"));
        courseRepository.insert(new Course(2, "Learn AWS", "Jitesh Nikale"));
        courseRepository.insert(new Course(3, "Learn DevOps", "Jitesh Nikale"));

        courseRepository.deleteById(2);

        System.out.println(courseRepository.findById(1));*/

        /*courseJPARepository.insert(new Course(1, "Learn Azure JPA", "Jitesh Nikale"));
        courseJPARepository.insert(new Course(2, "Learn AWS JPA", "Jitesh Nikale"));
        courseJPARepository.insert(new Course(3, "Learn DevOps JPA", "Jitesh Nikale"));

        courseJPARepository.deleteById(2);

        System.out.println(courseJPARepository.findById(1));*/

        /*courseSpringDataRepository.save(new Course(1, "Learn Azure JPA", "Amit Patil"));
        courseSpringDataRepository.save(new Course(2, "Learn AWS JPA", "Jitesh Nikale"));
        courseSpringDataRepository.save(new Course(3, "Learn DevOps JPA", "Jitesh Nikale"));

        courseSpringDataRepository.deleteById(2l);

        System.out.println(courseSpringDataRepository.findById(1l));

        System.out.println(courseSpringDataRepository.findByAuthor("Jitesh Nikale"));
        System.out.println(courseSpringDataRepository.findByName("Learn Azure JPA"));*/
    }
}
