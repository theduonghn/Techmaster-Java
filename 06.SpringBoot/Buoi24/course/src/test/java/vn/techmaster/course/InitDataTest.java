package vn.techmaster.course;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.Image;
import vn.techmaster.course.model.Topic;
import vn.techmaster.course.model.User;
import vn.techmaster.course.repository.CourseRepository;
import vn.techmaster.course.repository.ImageRepository;
import vn.techmaster.course.repository.TopicRepository;
import vn.techmaster.course.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@SpringBootTest
public class InitDataTest {
    @Autowired
    private Faker faker;
    @Autowired
    private Slugify slugify;
    @Autowired
    private Random random;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    void initData() {
        // List of types
        List<String> types = Arrays.asList("online", "onlab");

        // Create users
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .name(faker.name().username())
                    .email(faker.internet().emailAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .avatar(faker.company().logo())
                    .build();
            users.add(user);
            userRepository.save(user);
        }

        // Create topics
        List<Topic> topics = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Topic topic = Topic.builder()
                    .name(faker.lordOfTheRings().location())
                    .build();
            topics.add(topic);
            topicRepository.save(topic);
        }

        // Create courses
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = faker.educator().course();

            Set<Topic> selectedTopics = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                selectedTopics.add(topics.get(random.nextInt(topics.size())));
            }

            Course course = Course.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .type(types.get(random.nextInt(types.size())))
                    .description(faker.lorem().paragraph(10))
                    .thumbnail(faker.company().logo())
                    .supporter(i % 2 == 0 ? users.get(random.nextInt(users.size())) : null)
                    .topics(selectedTopics)
                    .build();
            courses.add(course);
            courseRepository.save(course);
        }


    }
}
