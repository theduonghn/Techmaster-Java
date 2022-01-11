
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @SerializedName("id")
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String mobile;
}
