package vn.techmaster.course;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.repository.CourseRepository;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Test
    void initData() {
        // List of types
        List<String> types = Arrays.asList("online", "onlab");

        // Create courses
        for (int i = 0; i < 10; i++) {
            String name = faker.educator().course();
            Course course = Course.builder()
                    .name(name)
                    .slug(slugify.slugify(name))
                    .type(types.get(random.nextInt(types.size())))
                    .description(faker.weather().description())
                    .thumbnail(faker.company().logo())
                    .build();

            courseRepository.save(course);
        }
    }
}
