package com.techmaster.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum City {
    HA_NOI("Hanoi"),
    HAI_PHONG("Hai Phong"),
    DA_NANG("Da Nang"),
    HO_CHI_MINH("Ho Chi Minh"),
    ALL_CITIES("All cities"),
    OTHER("Other"),;

    @JsonValue
    private String value;

    @JsonCreator
    public static City fromString(String value) {
        for (City status : City.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }
}