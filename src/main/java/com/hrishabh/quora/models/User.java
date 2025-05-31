package com.hrishabh.quora.models;

import com.hrishabh.quora.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")  // Avoid using "user" as it's a reserved word in some databases
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseModel {

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String fullName;

    private String bio;




}
