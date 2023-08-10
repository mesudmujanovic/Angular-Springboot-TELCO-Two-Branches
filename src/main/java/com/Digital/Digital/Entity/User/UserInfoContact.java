package com.Digital.Digital.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfoContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100)
    private String name;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Size(min = 8, message = "Email must have at least 8 characters")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(min = 6, message = "Phone must have at least 6 characters")
    private String phone;
}
