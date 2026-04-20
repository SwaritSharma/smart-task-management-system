package com.friday.taskmanagement.service;

import com.friday.taskmanagement.dto.*;
import com.friday.taskmanagement.entity.Task;
import com.friday.taskmanagement.entity.User;
import com.friday.taskmanagement.enums.TaskStatus;
import com.friday.taskmanagement.mapper.TaskMapper;
import com.friday.taskmanagement.mapper.UserMapper;
import com.friday.taskmanagement.repository.TaskRepository;
import com.friday.taskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private  static String userMssg="User ID not found";
    private  static String taskMssg="Task ID not found";

    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {
        User assignee=userRepo.findById(requestDTO.getUserId()).orElseThrow(()->new RuntimeException(userMssg));
        Task t=taskMapper.toEntity(requestDTO);
        t.setAssignee(assignee);
        t.setStatus(TaskStatus.TODO);
        t=taskRepository.save(t);
        return taskMapper.toDTO(t);
    }

    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks=taskRepository.findAll();
        return taskMapper.toDTOList(tasks);
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new RuntimeException(taskMssg));
        return taskMapper.toDTO(task);
    }

    public List<TaskResponseDTO> getTasksByUserId(Long id) {
        userRepo.findById(id).orElseThrow(()->new RuntimeException(userMssg));
        List<Task> tasks=taskRepository.findByAssigneeId(id);
        return taskMapper.toDTOList(tasks);
    }

    public void deleteTask(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new RuntimeException(taskMssg));
        taskRepository.delete(task);
    }


    public TaskStatusUpdateResponseDTO updateStatus(Long id, TaskStatusUpdateRequestDTO requestDTO) {
        Task task=taskRepository.findById(id).orElseThrow(()->new RuntimeException(taskMssg));
        if(requestDTO.getStatus()==null){
            throw new RuntimeException("Status Null Not Found");
        }
        task.setStatus(requestDTO.getStatus());
        task=taskRepository.save(task);
        return  taskMapper.toStatusUpdateDTO(task);
    }

    public TaskResponseDTO reassignAssignee(Long taskId, TaskAssignDTO requestDTO) {
        Task task=taskRepository.findById(taskId).orElseThrow(()->new RuntimeException(taskMssg));
        User newAssignee=userRepo.findById(requestDTO.getUserId()).orElseThrow(()->new RuntimeException(userMssg));
        task.setAssignee(newAssignee);
        task=taskRepository.save(task);
        return taskMapper.toDTO(task);
    }

    public TaskResponseDTO updateTask(Long id, TaskUpdateDTO requestDTO) {
        Task task=taskRepository.findById(id).orElseThrow(()->new RuntimeException(taskMssg));
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setDueDate(requestDTO.getDueDate());
        task=taskRepository.save(task);
        return taskMapper.toDTO(task);
    }

    public List<TaskResponseDTO> getTasksByStatus(TaskStatus status) {
        List<Task> tasks=taskRepository.findByStatus(status);
        return taskMapper.toDTOList(tasks);
    }

    public List<TaskResponseDTO> getTasksByUserIdAndSatus(Long id, TaskStatus status) {
        User u=userRepo.findById(id).orElseThrow(()->new RuntimeException(userMssg));
        if(status==null){
            throw new RuntimeException("Status Null Not Found");
        }
        List<Task> tasks=taskRepository.findByAssigneeIdAndStatus(id,status);
        return taskMapper.toDTOList(tasks);
    }
}
