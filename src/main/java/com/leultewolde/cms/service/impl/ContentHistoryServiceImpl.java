package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.ContentHistoryRequestDTO;
import com.leultewolde.cms.dto.response.ContentHistoryResponseDTO;
import com.leultewolde.cms.mapper.ContentHistoryMapper;
import com.leultewolde.cms.model.Content;
import com.leultewolde.cms.model.ContentHistory;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.ContentHistoryRepository;
import com.leultewolde.cms.repository.ContentRepository;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.ContentHistoryService;
import com.leultewolde.cms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentHistoryServiceImpl implements ContentHistoryService {

    private final ContentHistoryRepository contentHistoryRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final ContentHistoryMapper contentHistoryMapper;

    @Override
    public ContentHistoryResponseDTO createContentHistory(ContentHistoryRequestDTO contentHistoryRequestDTO) {
        ContentHistory contentHistory = contentHistoryMapper.toEntity(contentHistoryRequestDTO);
        Content content = contentRepository.findById(contentHistoryRequestDTO.getContentId())
                .orElseThrow(() -> new ResourceNotFoundException("Content not found"));
        User modifiedBy = userRepository.findById(contentHistoryRequestDTO.getModifiedByUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        contentHistory.setContent(content);
        contentHistory.setModifiedBy(modifiedBy);
        ContentHistory savedContentHistory = contentHistoryRepository.save(contentHistory);
        return contentHistoryMapper.toDTO(savedContentHistory);
    }

    @Override
    public Optional<ContentHistoryResponseDTO> updateContentHistory(Integer changeId, ContentHistoryRequestDTO contentHistoryRequestDTO) {
        return contentHistoryRepository.findById(changeId)
                .map(existingContentHistory -> {
                    contentHistoryMapper.updateEntityFromDTO(contentHistoryRequestDTO, existingContentHistory);
                    Content content = contentRepository.findById(contentHistoryRequestDTO.getContentId())
                            .orElseThrow(() -> new ResourceNotFoundException("Content not found"));
                    User modifiedBy = userRepository.findById(contentHistoryRequestDTO.getModifiedByUserId())
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                    existingContentHistory.setContent(content);
                    existingContentHistory.setModifiedBy(modifiedBy);
                    return contentHistoryMapper.toDTO(contentHistoryRepository.save(existingContentHistory));
                });
    }

    @Override
    public void deleteContentHistory(Integer changeId) {
        contentHistoryRepository.deleteById(changeId);
    }

    @Override
    public Optional<ContentHistoryResponseDTO> getContentHistoryById(Integer changeId) {
        return contentHistoryRepository.findById(changeId).map(contentHistoryMapper::toDTO);
    }

    @Override
    public List<ContentHistoryResponseDTO> getAllContentHistories() {
        return contentHistoryMapper.toDTO(contentHistoryRepository.findAll());
    }
}
