package vn.techmaster.jobhunt.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public record EmployerRequest(
        String id,

        @NotBlank(message = "Name cannot be null")
        String name,

        @NotBlank(message = "Website cannot be null")
        String website,

        @NotBlank(message = "Email cannot be null")
        @Email(message = "Invalid email")
        String email,
        
        MultipartFile logo) {
}
