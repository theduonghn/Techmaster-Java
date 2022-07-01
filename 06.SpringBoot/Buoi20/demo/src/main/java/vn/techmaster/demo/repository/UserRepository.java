package vn.techmaster.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
