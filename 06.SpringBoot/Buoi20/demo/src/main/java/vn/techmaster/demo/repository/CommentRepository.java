package vn.techmaster.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.demo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
