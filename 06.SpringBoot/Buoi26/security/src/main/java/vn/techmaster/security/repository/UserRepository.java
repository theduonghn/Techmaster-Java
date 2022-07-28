package vn.techmaster.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}