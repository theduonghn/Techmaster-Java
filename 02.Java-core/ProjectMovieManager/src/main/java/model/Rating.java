package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rating {
    private UUID userId;
    private UUID movieId;
    private int point;
}
