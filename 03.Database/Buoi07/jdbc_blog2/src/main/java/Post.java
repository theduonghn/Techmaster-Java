import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private int id_category;
    private int id_author;
    private LocalDate create_at;
    private String status;

    public Post(String title, String content, String description, String thumbnail, int id_category, int id_author,
                String status) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.thumbnail = thumbnail;
        this.id_category = id_category;
        this.id_author = id_author;
        this.status = status;
    }
}
