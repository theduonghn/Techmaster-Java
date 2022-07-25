package vn.techmaster.course.service;

import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.Topic;
import vn.techmaster.course.repository.CourseRepository;
import vn.techmaster.course.request.CourseEditRequest;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private Slugify slugify;

    public String showTopics(Course course) {
        return String.join(", ", course.getTopics().stream().map(Topic::getName).toList());
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course add(Course course) {
        course.setSlug(slugify.slugify(course.getName()));
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        course.setSlug(slugify.slugify(course.getName()));
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


    public CourseEditRequest toEditRequest(Course course) {
        return CourseEditRequest.builder()
                .id(course.getId())
                .name(course.getName())
                .slug(course.getSlug())
                .type(course.getType())
                .description(course.getDescription())
                .thumbnail(course.getThumbnail())
                .supporter(course.getSupporter())
                .topics(course.getTopics())
                .build();
    }

    public Course fromEditRequest(CourseEditRequest courseEditRequest) {
        String thumbnail = courseEditRequest.getThumbnail();
        if (thumbnail == null) {
            thumbnail = findById(courseEditRequest.getId()).getThumbnail();
        }

        return Course.builder()
                .id(courseEditRequest.getId())
                .name(courseEditRequest.getName())
                .slug(courseEditRequest.getSlug())
                .type(courseEditRequest.getType())
                .description(courseEditRequest.getDescription())
                .thumbnail(thumbnail)
                .supporter(courseEditRequest.getSupporter())
                .topics(courseEditRequest.getTopics())
                .build();
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }
}
