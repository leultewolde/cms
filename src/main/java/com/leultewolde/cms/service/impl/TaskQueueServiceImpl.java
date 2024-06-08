package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.TaskQueueRequestDTO;
import com.leultewolde.cms.dto.response.TaskQueueResponseDTO;
import com.leultewolde.cms.mapper.TaskQueueMapper;
import com.leultewolde.cms.model.TaskQueue;
import com.leultewolde.cms.repository.TaskQueueRepository;
import com.leultewolde.cms.service.TaskQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskQueueServiceImpl implements TaskQueueService {

    private final TaskQueueRepository taskQueueRepository;
    private final TaskQueueMapper taskQueueMapper;

    @Override
    public TaskQueueResponseDTO createTaskQueue(TaskQueueRequestDTO taskQueueRequestDTO) {
        TaskQueue taskQueue = taskQueueMapper.toEntity(taskQueueRequestDTO);
        TaskQueue savedTaskQueue = taskQueueRepository.save(taskQueue);
        return taskQueueMapper.toDTO(savedTaskQueue);
    }

    @Override
    public Optional<TaskQueueResponseDTO> updateTaskQueue(Integer queueId, TaskQueueRequestDTO taskQueueRequestDTO) {
        return taskQueueRepository.findById(queueId)
                .map(existingTaskQueue -> {
                    taskQueueMapper.updateEntityFromDTO(taskQueueRequestDTO, existingTaskQueue);
                    return taskQueueMapper.toDTO(taskQueueRepository.save(existingTaskQueue));
                });
    }

    @Override
    public void deleteTaskQueue(Integer queueId) {
        taskQueueRepository.deleteById(queueId);
    }

    @Override
    public Optional<TaskQueueResponseDTO> getTaskQueueById(Integer queueId) {
        return taskQueueRepository.findById(queueId).map(taskQueueMapper::toDTO);
    }

    @Override
    public List<TaskQueueResponseDTO> getAllTaskQueues() {
        return taskQueueMapper.toDTO(taskQueueRepository.findAll());
    }
}
