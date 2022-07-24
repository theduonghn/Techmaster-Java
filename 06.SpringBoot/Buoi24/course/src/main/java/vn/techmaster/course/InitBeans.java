package vn.techmaster.course;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class InitBeans {
    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public Slugify slugify() {
        return new Slugify();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}
