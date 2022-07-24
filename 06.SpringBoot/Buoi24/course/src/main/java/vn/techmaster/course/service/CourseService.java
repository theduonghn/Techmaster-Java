package vn.techmaster.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.Topic;
import vn.techmaster.course.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public String showTopics(Course course) {
        return String.join(", ", course.getTopics().stream().map(Topic::getName).toList());
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course with id = \" + id + \" does not exist"));
    }

    public List<Course> findByType(String type) {
        return courseRepository.findByType(type);
    }

    public List<Course> findByName(String name) {
        if (name == null) {
            return findAll();
        }
        return courseRepository.findByName(name);
    }

    public List<Course> findByNameAndTopicId(String name, Integer topicId) {
        if (topicId == null) {
            return findByName(name);
        }
        return courseRepository.findByNameAndTopicId(name, topicId);
    }

    public List<Course> findByTypeAndNameAndTopicId(String type, String name, Integer topicId) {
        if (name == null && topicId == null) {
            return findByType(type);
        } else if (name == null) {
            return findByTypeAndTopicId(type, topicId);
        } else if (topicId == null) {
            return findByTypeAndName(type, name);
        }
        return courseRepository.findByTypeAndNameAndTopicId(type, name, topicId);
    }

    private List<Course> findByTypeAndName(String type, String name) {
        if (name == null) {
            return findByType(type);
        }
        return courseRepository.findByTypeAndName(type, name);
    }

    private List<Course> findByTypeAndTopicId(String type, Integer topicId) {
        if (topicId == null) {
            return findByType(type);
        }
        return courseRepository.findByTypeAndTopicId(type, topicId);
    }


}
