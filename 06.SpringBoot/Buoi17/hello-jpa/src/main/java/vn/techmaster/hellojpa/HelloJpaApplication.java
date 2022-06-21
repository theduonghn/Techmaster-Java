package vn.techmaster.hellojpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import vn.techmaster.hellojpa.model.Employer;

@SpringBootApplication
@Transactional
@AllArgsConstructor
public class HelloJpaApplication implements ApplicationRunner {
	private EntityManager en;

	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker();
		for (int i = 0; i < 100; i++) {
			Employer employer = Employer.builder()
					.name(faker.name().fullName())
					.email(faker.internet().emailAddress())
					.website("https://" + faker.internet().domainName())
					.build();
			en.persist(employer);
		}
		en.flush();
	}

}
