package com.friday.taskmanagement.service;

import com.friday.taskmanagement.dto.UserRequestDTO;
import com.friday.taskmanagement.dto.UserResponseDTO;
import com.friday.taskmanagement.entity.User;
import com.friday.taskmanagement.mapper.UserMapper;
import com.friday.taskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepo;
    private String mssg="User not found";

    public UserResponseDTO addUser(UserRequestDTO requestDTO) {
        User u=userMapper.toEntity(requestDTO);
        if(u.getEmail().endsWith("@taskmanagement.com")){
            u.setRole("ADMIN");
        }
        else {
            u.setRole("USER");
        }
        u=userRepo.save(u);
        return userMapper.toDTO(u);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users=userRepo.findAll();
        return userMapper.toDTOList(users);
    }

    public UserResponseDTO getUserById(Long id) {
        User res=userRepo.findById(id).orElseThrow(()->new RuntimeException(mssg));
        return userMapper.toDTO(res);
    }

    public void deleteUserById(Long id) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException(mssg));
        userRepo.delete(user);
    }

    public UserResponseDTO updateUser(Long id,UserRequestDTO requestDTO) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException(mssg));
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        user.setUsername(requestDTO.getUsername());
        user.setPhoneNumber(requestDTO.getPhoneNumber());
        user.setAddress(requestDTO.getAddress());
        if(user.getEmail().endsWith("@taskmanagement.com")){
            user.setRole("ADMIN");
        }else{
            user.setRole("USER");
        }
        return userMapper.toDTO(userRepo.save(user));
    }
}
