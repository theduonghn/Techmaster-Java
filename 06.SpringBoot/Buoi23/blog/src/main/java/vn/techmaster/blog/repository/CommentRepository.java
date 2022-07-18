package vn.techmaster.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.techmaster.blog.entity.Comment;
import vn.techmaster.blog.dto.CommentInfo;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.blog.id = :id")
    List<CommentInfo> getCommentsByBlogId(@Param("id") String id);
}