package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.TaskQueueRequestDTO;
import com.leultewolde.cms.dto.response.TaskQueueResponseDTO;
import com.leultewolde.cms.service.TaskQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task-queues")
@RequiredArgsConstructor
public class TaskQueueController {

    private final TaskQueueService taskQueueService;

    @PostMapping
    public ResponseEntity<TaskQueueResponseDTO> createTaskQueue(@RequestBody TaskQueueRequestDTO taskQueueRequestDTO) {
        TaskQueueResponseDTO createdTaskQueue = taskQueueService.createTaskQueue(taskQueueRequestDTO);
        return ResponseEntity.ok(createdTaskQueue);
    }

    @PutMapping("/{queueId}")
    public ResponseEntity<TaskQueueResponseDTO> updateTaskQueue(@PathVariable Integer queueId, @RequestBody TaskQueueRequestDTO taskQueueRequestDTO) {
        Optional<TaskQueueResponseDTO> updatedTaskQueue = taskQueueService.updateTaskQueue(queueId, taskQueueRequestDTO);
        return updatedTaskQueue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{queueId}")
    public ResponseEntity<Void> deleteTaskQueue(@PathVariable Integer queueId) {
        taskQueueService.deleteTaskQueue(queueId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{queueId}")
    public ResponseEntity<TaskQueueResponseDTO> getTaskQueueById(@PathVariable Integer queueId) {
        Optional<TaskQueueResponseDTO> taskQueue = taskQueueService.getTaskQueueById(queueId);
        return taskQueue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TaskQueueResponseDTO>> getAllTaskQueues() {
        List<TaskQueueResponseDTO> taskQueues = taskQueueService.getAllTaskQueues();
        return ResponseEntity.ok(taskQueues);
    }
}
