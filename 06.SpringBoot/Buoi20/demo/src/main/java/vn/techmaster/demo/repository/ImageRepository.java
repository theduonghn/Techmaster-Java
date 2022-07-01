package vn.techmaster.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.demo.entity.Image;

public interface ImageRepository extends JpaRepository<Image, UUID> {
    List<Image> getImageByUserId(Integer id);
}
