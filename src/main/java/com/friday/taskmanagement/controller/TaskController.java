package com.friday.taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import com.friday.taskmanagement.dto.*;
import com.friday.taskmanagement.enums.TaskStatus;
import com.friday.taskmanagement.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService ser;

    @PostMapping("/add")
    public ResponseEntity<TaskResponseDTO> addTask(@RequestBody TaskRequestDTO requestDTO) {
        return new ResponseEntity<>(ser.createTask(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<TaskResponseDTO>> fetchAllTasks() {
        return new ResponseEntity<>(ser.getAllTasks(),HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<TaskResponseDTO> fetchTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(ser.getTaskById(id),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TaskResponseDTO>> fetchTasksByUserId(@PathVariable Long id){
        return new ResponseEntity<>(ser.getTasksByUserId(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        ser.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskStatusUpdateResponseDTO>  updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusUpdateRequestDTO requestDTO){
        return new ResponseEntity<>(ser.updateStatus(id,requestDTO),HttpStatus.OK);
    }

    @PatchMapping("/{id}/assign")
    public ResponseEntity<TaskResponseDTO> updateTaskAssignee(@PathVariable Long id, @RequestBody TaskAssignDTO  requestDTO){
        return new ResponseEntity<>(ser.reassignAssignee(id,requestDTO),HttpStatus.OK);
    }

    @PatchMapping("/{id}/update")
    public  ResponseEntity<TaskResponseDTO> updateTask(@RequestBody TaskUpdateDTO  requestDTO, @PathVariable Long id){
        return new ResponseEntity<>(ser.updateTask(id,requestDTO),HttpStatus.OK);
    }

    @GetMapping("/fetchTasksByStatus")
    public ResponseEntity<List<TaskResponseDTO>> fetchTasksByStatus(@RequestParam TaskStatus status){
        return new ResponseEntity<>(ser.getTasksByStatus(status),HttpStatus.OK);
    }

    @GetMapping("/user/{id}/status")
    public ResponseEntity<List<TaskResponseDTO>> fetchTasksByUserIdAndStatus(@PathVariable Long id , @RequestParam TaskStatus status){
        return new ResponseEntity<>(ser.getTasksByUserIdAndSatus(id,status),HttpStatus.OK);
    }
    
}
