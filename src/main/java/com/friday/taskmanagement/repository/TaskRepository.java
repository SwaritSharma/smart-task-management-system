package com.friday.taskmanagement.repository;

import com.friday.taskmanagement.entity.Task;
import com.friday.taskmanagement.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssigneeId(Long userId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByAssigneeIdAndStatus(Long userId, TaskStatus status);
}
