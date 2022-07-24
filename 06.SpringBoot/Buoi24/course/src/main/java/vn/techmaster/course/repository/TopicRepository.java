package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.course.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}