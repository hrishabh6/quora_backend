package com.hrishabh.quora.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String bio;
}
