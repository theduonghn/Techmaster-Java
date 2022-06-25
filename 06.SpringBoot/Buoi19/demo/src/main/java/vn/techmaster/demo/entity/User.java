package vn.techmaster.demo.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.demo.dto.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@NamedNativeQuery(name = "getUserInfo", resultSetMapping = "userInfo", query = "SELECT user.id, user.name, user.email "
                +
                "FROM user " +
                "WHERE user.email = ?1")
@SqlResultSetMapping(name = "userInfo", classes = @ConstructorResult(targetClass = UserDto.class, columns = {
                @ColumnResult(name = "id"),
                @ColumnResult(name = "name"),
                @ColumnResult(name = "email")
}))
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Integer id;
        private String name;
        @Column(unique = true)
        private String email;
        private String password;
        private String avatar;
}
