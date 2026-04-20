package com.friday.taskmanagement.mapper;

import com.friday.taskmanagement.dto.UserRequestDTO;
import com.friday.taskmanagement.dto.UserResponseDTO;
import com.friday.taskmanagement.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO requestDTO);
    UserResponseDTO toDTO(User user);
    List<UserResponseDTO> toDTOList(List<User> users);

}
