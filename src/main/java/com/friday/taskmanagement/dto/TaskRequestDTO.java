package com.friday.taskmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank(message = "Task Title can't be blank")
    @Size(min = 5, max = 100)
    private String title;

    @Size(max = 200,message = "Description can be maximum 200 characters")
    private String description;

    @NotBlank(message = "Due date is required")
    private String dueDate;

    @NotNull(message = "Task should have an existing assignee")
    private Long userId;

    @NotBlank(message = "Task should have an existing assignee")
    private String userName;
}
