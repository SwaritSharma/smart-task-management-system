package com.friday.taskmanagement.controller;

import com.friday.taskmanagement.dto.UserRequestDTO;
import com.friday.taskmanagement.dto.UserResponseDTO;
import com.friday.taskmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService ser;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        return new ResponseEntity<>(ser.addUser(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<UserResponseDTO>> fetchAllUsers() {
        return new ResponseEntity<>(ser.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserResponseDTO> fetchUser(@PathVariable Long id) {
        return new ResponseEntity<>(ser.getUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        ser.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id ,@Valid @RequestBody UserRequestDTO requestDTO) {
        return new ResponseEntity<>(ser.updateUser(id,requestDTO),HttpStatus.OK);
    }
}
