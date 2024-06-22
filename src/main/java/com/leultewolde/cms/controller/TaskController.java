package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.TaskRequestDTO;
import com.leultewolde.cms.dto.response.TaskResponseDTO;
import com.leultewolde.cms.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO createdTask = taskService.createTask(taskRequestDTO);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{taskId}")
    @PreAuthorize("hasAnyAuthority('admin:read','admin:write','contributor:read','contributor:write','reviewer:read','reviewer:write')")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Integer taskId, @RequestBody TaskRequestDTO taskRequestDTO) {
        Optional<TaskResponseDTO> updatedTask = taskService.updateTask(taskId, taskRequestDTO);
        return updatedTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{taskId}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Integer taskId) {
        Optional<TaskResponseDTO> task = taskService.getTaskById(taskId);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("user/{username}")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasksByUser(@PathVariable String username) {
        List<TaskResponseDTO> tasks = taskService.getTasksByUsername(username);
        return ResponseEntity.ok(tasks);
    }
}
