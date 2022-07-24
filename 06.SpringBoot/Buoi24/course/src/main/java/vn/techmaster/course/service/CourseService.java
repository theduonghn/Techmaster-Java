package vn.techmaster.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
