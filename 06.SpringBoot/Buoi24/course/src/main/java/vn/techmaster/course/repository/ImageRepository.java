package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.course.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}