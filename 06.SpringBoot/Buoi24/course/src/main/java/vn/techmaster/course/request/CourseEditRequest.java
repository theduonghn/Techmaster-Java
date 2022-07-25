package vn.techmaster.course.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.model.Topic;
import vn.techmaster.course.model.User;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseEditRequest {
    private Integer id;
    private String name;
    private String slug;
    private String type;
    private String description;
    private String thumbnail;
    private User supporter;
    private Set<Topic> topics = new LinkedHashSet<>();
    private MultipartFile image;
}
