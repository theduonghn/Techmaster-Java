package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.course.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}