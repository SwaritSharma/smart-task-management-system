package com.friday.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;
}
