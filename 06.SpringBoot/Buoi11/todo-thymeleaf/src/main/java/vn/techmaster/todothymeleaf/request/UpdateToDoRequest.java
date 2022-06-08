package vn.techmaster.todothymeleaf.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateToDoRequest {
    private String title;
    private boolean status;
}
