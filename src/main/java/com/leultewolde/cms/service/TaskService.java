package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.TaskRequestDTO;
import com.leultewolde.cms.dto.response.TaskResponseDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    Optional<TaskResponseDTO> updateTask(Integer taskId, TaskRequestDTO taskRequestDTO);

    void deleteTask(Integer taskId);

    Optional<TaskResponseDTO> getTaskById(Integer taskId);

    List<TaskResponseDTO> getTasksByUsername(String username);

    List<TaskResponseDTO> getAllTasks();
}

