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
}
