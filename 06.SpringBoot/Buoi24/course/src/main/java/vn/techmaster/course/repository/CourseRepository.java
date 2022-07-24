package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}