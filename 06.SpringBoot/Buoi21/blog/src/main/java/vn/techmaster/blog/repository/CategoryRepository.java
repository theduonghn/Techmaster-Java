package vn.techmaster.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.blog.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}