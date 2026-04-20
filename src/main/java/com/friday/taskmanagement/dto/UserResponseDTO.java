package com.friday.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;
}
