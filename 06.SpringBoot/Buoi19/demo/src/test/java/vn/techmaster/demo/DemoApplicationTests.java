package vn.techmaster.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import vn.techmaster.demo.dto.UserDto;
import vn.techmaster.demo.entity.User;
import vn.techmaster.demo.repository.UserRepository;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertUserTest() {
		User user = new User(null, "Nguyễn Văn A1", "a1@gmail.com", null, null);
		User user1 = new User(null, "Nguyễn Văn B1", "b1@gmail.com", null, null);
		User user2 = new User(null, "Nguyễn Văn C1", "c1@gmail.com", null, null);

		userRepository.save(user);
		userRepository.save(user1);
		userRepository.save(user2);
	}

	@Test
	void countByNameContainsIgnoreCaseTest() {
		long count = userRepository.countByNameContainsIgnoreCase("c");
		Assertions.assertThat(count).isEqualTo(1L);
	}

	@Test
	void sortNameDescTest() {
		List<User> users = userRepository.findByOrderByNameDesc(Sort.by("name").descending());
		users.forEach(user -> System.out.println(user.getName()));
	}

	@Test
	void findByEmailReturnDtoTest() {
		UserDto userDto = userRepository.findByEmail("a@gmail.com");
		Assertions.assertThat(userDto.getName()).isEqualTo("Nguyễn Văn A");
	}

}
