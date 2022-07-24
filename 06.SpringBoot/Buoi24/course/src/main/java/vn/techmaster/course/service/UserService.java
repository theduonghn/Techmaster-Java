package vn.techmaster.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.course.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
