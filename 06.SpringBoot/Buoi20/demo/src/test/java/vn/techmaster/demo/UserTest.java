package vn.techmaster.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.demo.dto.UserDto;
import vn.techmaster.demo.entity.User;
import vn.techmaster.demo.projection.UserInfo;
import vn.techmaster.demo.repository.UserRepository;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void get_user_dto_by_id_test() {
        UserDto userDto = userRepository.getUserDto(21);
        System.out.println(userDto);
    }

    @Test
    void get_user_info_by_id_test() {
        UserInfo userInfo = userRepository.getUserById(21, UserInfo.class);
        userInfo.showInfo();

        //        UserDto userDto = userRepository.getUserById(21, UserDto.class);
        //        System.out.println(userDto);

        User user = userRepository.getUserById(21, User.class);
        System.out.println(user);
    }
}
