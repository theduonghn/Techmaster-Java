package vn.techmaster.blog.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@ToString
public class BlogInfo {
    private String id;
    private String title;
    private String slug;
    private String description;
    private String content;
    private String thumbnail;
    private String publishedAt;
    private int countComment;
    private AuthorInfo authorInfo;

    public BlogInfo(String id, String title, String slug, String description, String content, String thumbnail, String publishedAt,
                    int countComment, String authorInfo) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.publishedAt = publishedAt;
        this.countComment = countComment;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.authorInfo = objectMapper.readValue(authorInfo, AuthorInfo.class);
        } catch (JsonProcessingException e) {
            this.authorInfo = null;
        }
    }
}



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class AuthorInfo {
    private int id;
    private String name;
}
