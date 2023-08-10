package com.Digital.Digital.Infrastructure.Request.UserRequest.UserInfoContact;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserInfoContactRequest {

    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 3)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Size(min = 8, message = "Email must have at least 8 characters")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(min = 6, message = "Phone must have at least 6 characters")
    private String phone;
}
