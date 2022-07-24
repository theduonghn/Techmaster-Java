package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techmaster.course.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByType(String type);

    @Query("select c from Course c where upper(c.name) like upper(concat('%', ?1, '%'))")
    List<Course> findByName(String name);

    @Query("""
            select c from Course c inner join c.topics topics
            where upper(c.name) like upper(concat('%', ?1, '%')) and topics.id = ?2""")
    List<Course> findByNameAndTopicId(String name, Integer topicId);

    @Query("""
            select c from Course c inner join c.topics topics
            where c.type = ?1 and upper(c.name) like upper(concat('%', ?2, '%')) and topics.id = ?3""")
    List<Course> findByTypeAndNameAndTopicId(String type, String name, Integer topicId);

    @Query("select c from Course c where c.type = ?1 and upper(c.name) like upper(concat('%', ?2, '%'))")
    List<Course> findByTypeAndName(String type, String name);

    @Query("select c from Course c inner join c.topics topics where c.type = ?1 and topics.id = ?2")
    List<Course> findByTypeAndTopicId(String type, Integer topicId);


}