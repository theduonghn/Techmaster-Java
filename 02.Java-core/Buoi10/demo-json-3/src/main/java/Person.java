import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("gender")
    private String gender;

    @SerializedName("mobile")
    private String mobile;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
