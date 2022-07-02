package vn.techmaster.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(generator = "custom_generator")
    @GenericGenerator(name = "custom_generator", strategy = "vn.techmaster.demo.generator.CustomIdGenerator")
    @Column(name = "id", nullable = false)
    private String id;

    private String title;

    private String slug;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

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
    @JoinTable(name = "blog_categories",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
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
