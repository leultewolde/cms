package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.TaskQueueRequestDTO;
import com.leultewolde.cms.dto.response.TaskQueueResponseDTO;

import java.util.List;
import java.util.Optional;

public interface TaskQueueService {
    TaskQueueResponseDTO createTaskQueue(TaskQueueRequestDTO taskQueueRequestDTO);

    Optional<TaskQueueResponseDTO> updateTaskQueue(Integer queueId, TaskQueueRequestDTO taskQueueRequestDTO);

    void deleteTaskQueue(Integer queueId);

    Optional<TaskQueueResponseDTO> getTaskQueueById(Integer queueId);

    List<TaskQueueResponseDTO> getAllTaskQueues();
}
