package com.friday.taskmanagement.dto;

import com.friday.taskmanagement.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskStatusUpdateRequestDTO {

    @NotNull(message="Task Status cannot be null")
    private TaskStatus status;
}
