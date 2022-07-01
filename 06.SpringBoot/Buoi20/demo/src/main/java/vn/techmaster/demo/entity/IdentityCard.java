package vn.techmaster.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "identity_card")
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "expired", columnDefinition = "TIMESTAMP")
    private LocalDateTime expired;

    @Column(name = "issued", columnDefinition = "TIMESTAMP")
    private LocalDateTime issued;

    @PrePersist
    public void prePersist() {
        issued = LocalDateTime.now().minusYears(2);
        expired = LocalDateTime.now().plusYears(2);
    }
}
