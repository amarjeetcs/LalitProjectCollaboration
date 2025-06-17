package com.lalit.kumar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String username;
    private String password; // Encrypted
    private String role; // Example: ROLE_ADMIN or ROLE_USER
}
