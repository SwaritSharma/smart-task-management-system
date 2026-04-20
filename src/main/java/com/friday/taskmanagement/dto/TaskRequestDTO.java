package com.friday.taskmanagement.dto;

import com.friday.taskmanagement.enums.TaskStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequestDTO {

    private String title;
    private String description;
    private String dueDate;
    private Long userId;
    private String userName;
}
