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
import vn.techmaster.hellojpa.model.Job;

@SpringBootApplication
@AllArgsConstructor
public class HelloJpaApplication implements ApplicationRunner {
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		Faker faker = new Faker();
		for (int i = 0; i < 100; i++) {
			Employer employer = Employer.builder()
					.name(faker.name().fullName())
					.email(faker.internet().emailAddress())
					.website("https://" + faker.internet().domainName())
					.build();
			entityManager.persist(employer);
		}

		for (int i = 0; i < 100; i++) {
			Job job = Job.builder()
					.title(faker.name().name())
					.description(faker.animal().name())
					.build();
			entityManager.persist(job);
		}

		entityManager.flush();
	}

}
