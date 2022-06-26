package vn.techmaster.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import vn.techmaster.usermanagement.service.UserService;

@Component
public class ApplicationStartRunner implements ApplicationRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addActiveUser("admin", "admin@gmail.com", "123456");
        userService.addUser("John", "john@gmail.com", "123456");
    }

}
