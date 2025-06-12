package com.lalit.kumar.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // ✅ Lombok: generates getters, setters, toString, equals, hashCode
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Gender is required")
    private String gender;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 60")
    private int age;

    @NotBlank(message = "City is required")
    private String city;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String number;

    @NotBlank(message = "Company name is required")
    private String company;

    @PositiveOrZero(message = "Salary must be zero or positive")
    private double salary;

    @NotBlank(message = "Country is required")
    private String country;
}
