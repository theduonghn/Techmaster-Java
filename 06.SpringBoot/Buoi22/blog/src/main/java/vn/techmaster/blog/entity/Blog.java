package vn.techmaster.blog.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import vn.techmaster.blog.dto.BlogInfo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SqlResultSetMapping(name = "listBlogInfo", classes = @ConstructorResult(targetClass = BlogInfo.class, columns = {
        @ColumnResult(name = "id", type = String.class),
        @ColumnResult(name = "title", type = String.class),
        @ColumnResult(name = "slug", type = String.class),
        @ColumnResult(name = "description", type = String.class),
        @ColumnResult(name = "content", type = String.class),
        @ColumnResult(name = "thumbnail", type = String.class),
        @ColumnResult(name = "published_at", type = String.class),
        @ColumnResult(name = "count_comment", type = Integer.class),
        @ColumnResult(name = "author", type = String.class) }))
@NamedNativeQuery(name = "getAllBlogInfo", resultSetMapping = "listBlogInfo", query = "SELECT b.id, b.title, b.slug, b.description, b.content, b.thumbnail,\n"
        +
        "DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  \n" +
        "JSON_OBJECT('id', u.id, \"name\", u.name) as author,\n" + "COUNT(c.id) as count_comment\n" +
        "FROM blog b\n" + "LEFT JOIN `user` u \n" + "ON b.user_id = u.id\n" + "LEFT JOIN comment c \n" +
        "ON b.id = c.blog_id \n" + "WHERE b.status = 1\n" + "GROUP BY b.id \n" +
        "ORDER BY b.published_at DESC ")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(generator = "custom_generate")
    @GenericGenerator(name = "custom_generate", strategy = "vn.techmaster.blog.generator.CustomIdGenerator")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "published_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime publishedAt;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "blog_categories", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Category> categories = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now().minusMonths(2);
        updatedAt = createdAt;
        if (status == 1) {
            publishedAt = updatedAt;
        }
    }
}