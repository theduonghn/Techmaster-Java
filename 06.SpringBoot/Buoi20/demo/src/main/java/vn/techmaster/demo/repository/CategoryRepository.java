package vn.techmaster.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.demo.entity.Blog;
import vn.techmaster.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
