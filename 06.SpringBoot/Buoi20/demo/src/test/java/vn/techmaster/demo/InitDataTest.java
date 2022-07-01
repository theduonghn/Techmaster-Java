package vn.techmaster.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.annotations.SourceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import vn.techmaster.demo.entity.Blog;
import vn.techmaster.demo.entity.Category;
import vn.techmaster.demo.entity.Comment;
import vn.techmaster.demo.entity.IdentityCard;
import vn.techmaster.demo.entity.Image;
import vn.techmaster.demo.entity.User;
import vn.techmaster.demo.repository.BlogRepository;
import vn.techmaster.demo.repository.CategoryRepository;
import vn.techmaster.demo.repository.CommentRepository;
import vn.techmaster.demo.repository.IdentityCardRepository;
import vn.techmaster.demo.repository.ImageRepository;
import vn.techmaster.demo.repository.UserRepository;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
public class InitDataTest {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IdentityCardRepository identityCardRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Faker faker;

    @Autowired
    private Slugify slugify;

    @Autowired
    private Random random;

    @Test
    void saveUserIdentityCard() {
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password(faker.number().digits(3))
                    .identityCard(new IdentityCard())
                    .build();

            userRepository.save(user);
        }
    }

    @Test
    void saveCategory() {
        for (int i = 0; i < 10; i++) {
            Category category = Category.builder()
                    .name(faker.leagueOfLegends().champion())
                    .build();
            categoryRepository.save(category);
        }
    }

    @Test
    void saveImage() {
        List<User> users = userRepository.findAll();

        for (int i = 0; i < 10; i++) {
            User userRd = users.get(random.nextInt(users.size()));

            Image image = Image.builder()
                    .url(faker.internet().image())
                    .user(userRd)
                    .build();

            imageRepository.save(image);
        }
    }

    @Test
    void saveBlog() {
        List<User> users = userRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        for (int i = 0; i < 30; i++) {
            User userRd = users.get(random.nextInt(users.size()));

            List<Image> images = imageRepository.getImageByUserId(userRd.getId());
            String imageRd = images.get(random.nextInt(images.size())).getUrl();

            List<Category> categoriesRd = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Category categoryRd = categories.get(random.nextInt(categories.size()));
                if (!categoriesRd.contains(categoryRd)) {
                    categoriesRd.add(categoryRd);
                }
            }

            String title = faker.lorem().sentence(10);

            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().sentence(50))
                    .content(faker.lorem().sentence(200))
                    .thumbnail(imageRd)
                    .categories(categoriesRd)
                    .user(userRd)
                    .build();

            blogRepository.save(blog);
        }
    }

    @Test
    void saveComment() {
        List<User> users = userRepository.findAll();
        List<Blog> blogs = blogRepository.findAll();

        for (int i = 0; i < 100; i++) {
            User userRd = users.get(random.nextInt(users.size()));
            Blog blogRd = blogs.get(random.nextInt(blogs.size()));

            Comment comment = Comment.builder()
                    .content(faker.lorem().sentence(20))
                    .user(userRd)
                    .blog(blogRd)
                    .build();

            commentRepository.save(comment);
        }
    }

    @Test
    void getImagesByUserId() {
        List<Image> images = imageRepository.getImageByUserId(21);
        images.forEach(image -> System.out.println(image));
    }
}
