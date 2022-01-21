package model;

import com.google.gson.annotations.SerializedName;

public enum Gender {
    @SerializedName("Male")
    MALE("Nam"),

    @SerializedName("Female")
    FEMALE("Nữ");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
