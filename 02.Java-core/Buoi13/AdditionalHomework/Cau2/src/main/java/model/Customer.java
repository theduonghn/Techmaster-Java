package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    @SerializedName("id")
    private String id;

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("gender")
    private Gender gender;

    @SerializedName("hometown")
    private String hometown;

    @SerializedName("phone")
    private String phone;

    @SerializedName("email")
    private String email;
}
