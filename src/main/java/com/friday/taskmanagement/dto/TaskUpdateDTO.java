package com.friday.taskmanagement.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskUpdateDTO {

    private String title;
    private String description;
    private String dueDate;
}
