import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String gender;
    private String address;
    private String mobile;
    private LocalDate create_at;

    public User(String name, String gender, String address, String mobile) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.mobile = mobile;
    }
}
