package com.friday.taskmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskUpdateDTO {

    @Size(min = 5, max = 100)
    private String title;

    @Size(max=200)
    private String description;
    
    private String dueDate;
}
