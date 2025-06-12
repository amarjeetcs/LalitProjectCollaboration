package com.lalit.kumar.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 60")
    private Integer age;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String number;

    @NotBlank(message = "Company name is required")
    private String company;

    @NotNull(message = "Salary must not be null")
    @PositiveOrZero(message = "Salary must be zero or positive")
    private Double salary;

    @NotBlank(message = "Country is required")
    private String country;
}
