package com.friday.taskmanagement.mapper;

import com.friday.taskmanagement.dto.TaskRequestDTO;
import com.friday.taskmanagement.dto.TaskResponseDTO;
import com.friday.taskmanagement.dto.TaskStatusUpdateResponseDTO;
import com.friday.taskmanagement.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "assignee" , ignore = true)
    Task toEntity(TaskRequestDTO requestDTO);

//  task.getAssignee().getId() → dto.userId
//  task.getAssignee().getUsername() → dto.userName
    @Mapping(source = "assignee.id" , target = "userId")
    @Mapping(source = "assignee.username" , target = "userName")
    TaskResponseDTO toDTO(Task task);

    List<TaskResponseDTO> toDTOList(List<Task> tasks);

    TaskStatusUpdateResponseDTO toStatusUpdateDTO(Task task);
}
