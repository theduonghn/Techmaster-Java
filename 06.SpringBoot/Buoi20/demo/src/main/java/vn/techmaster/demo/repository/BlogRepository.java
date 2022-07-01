package vn.techmaster.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.demo.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {

}
