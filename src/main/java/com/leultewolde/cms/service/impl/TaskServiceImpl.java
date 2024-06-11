package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.TaskRequestDTO;
import com.leultewolde.cms.dto.response.TaskResponseDTO;
import com.leultewolde.cms.mapper.TaskMapper;
import com.leultewolde.cms.model.PublishingPlatform;
import com.leultewolde.cms.model.Task;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.PublishingPlatformRepository;
import com.leultewolde.cms.repository.TaskRepository;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.TaskService;
import com.leultewolde.cms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PublishingPlatformRepository publishingPlatformRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        User assignedTo = userRepository.findById(taskRequestDTO.getAssignedToUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        task.setAssignedTo(assignedTo);
        List<PublishingPlatform> platforms = publishingPlatformRepository.findAllById(taskRequestDTO.getTargetPlatformIds());
        task.setTargetPlatforms(platforms);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public Optional<TaskResponseDTO> updateTask(Integer taskId, TaskRequestDTO taskRequestDTO) {
        return taskRepository.findById(taskId)
                .map(existingTask -> {
                    taskMapper.updateEntityFromDTO(taskRequestDTO, existingTask);
                    User assignedTo = userRepository.findById(taskRequestDTO.getAssignedToUserId())
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                    existingTask.setAssignedTo(assignedTo);
                    List<PublishingPlatform> platforms = publishingPlatformRepository.findAllById(taskRequestDTO.getTargetPlatformIds());
                    existingTask.setTargetPlatforms(platforms);
                    return taskMapper.toDTO(taskRepository.save(existingTask));
                });
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Optional<TaskResponseDTO> getTaskById(Integer taskId) {
        return taskRepository.findById(taskId).map(taskMapper::toDTO);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskMapper.toDTO(taskRepository.findAll());
    }
}

