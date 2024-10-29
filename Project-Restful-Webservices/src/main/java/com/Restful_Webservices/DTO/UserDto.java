package com.Restful_Webservices.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    private int id;

    // User firstName should not be null or Empty
    @NotEmpty(message = "User firstName should not be null or Empty")
    @Size(min = 2, message = "FirstName should minimum TWO characters")
    @Size(max = 20, message = "FirstName should maximum TWENTY characters")
    private String firstName;

    // User lastName should not be null or Empty
    @NotEmpty(message = "User lastName should not be null or Empty")
    private String lastName;

    // User email should not be null or Empty
    // Email Address should be valid
    @NotEmpty(message = "User e-mail should not be null or Empty")
    @Email(message = "Email address should be valid")
    private String email;

}
