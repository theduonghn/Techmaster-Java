package vn.techmaster.demo;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

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
