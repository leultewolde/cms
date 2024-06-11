package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.ContentRequestDTO;
import com.leultewolde.cms.dto.response.ContentResponseDTO;
import com.leultewolde.cms.mapper.ContentMapper;
import com.leultewolde.cms.model.Content;
import com.leultewolde.cms.model.Task;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.ContentRepository;
import com.leultewolde.cms.repository.TaskRepository;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.ContentService;
import com.leultewolde.cms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ContentMapper contentMapper;

    @Override
    public ContentResponseDTO createContent(ContentRequestDTO contentRequestDTO) {
        Content content = contentMapper.toEntity(contentRequestDTO);
        User createdBy = userRepository.findById(contentRequestDTO.getCreatedByUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Task task = taskRepository.findById(contentRequestDTO.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        content.setCreatedBy(createdBy);
        content.setBelongsTo(task);
        Content savedContent = contentRepository.save(content);
        return contentMapper.toDTO(savedContent);
    }

    @Override
    public Optional<ContentResponseDTO> updateContent(Integer contentId, ContentRequestDTO contentRequestDTO) {
        return contentRepository.findById(contentId)
                .map(existingContent -> {
                    contentMapper.updateEntityFromDTO(contentRequestDTO, existingContent);
                    User createdBy = userRepository.findById(contentRequestDTO.getCreatedByUserId())
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                    Task task = taskRepository.findById(contentRequestDTO.getTaskId())
                            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
                    existingContent.setCreatedBy(createdBy);
                    existingContent.setBelongsTo(task);
                    return contentMapper.toDTO(contentRepository.save(existingContent));
                });
    }

    @Override
    public void deleteContent(Integer contentId) {
        contentRepository.deleteById(contentId);
    }

    @Override
    public Optional<ContentResponseDTO> getContentById(Integer contentId) {
        return contentRepository.findById(contentId).map(contentMapper::toDTO);
    }

    @Override
    public List<ContentResponseDTO> getAllContents() {
        return contentMapper.toDTO(contentRepository.findAll());
    }
}
