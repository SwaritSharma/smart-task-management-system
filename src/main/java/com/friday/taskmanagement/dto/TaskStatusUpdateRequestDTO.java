package com.friday.taskmanagement.dto;

import com.friday.taskmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskStatusUpdateRequestDTO {

    private TaskStatus status;
}
