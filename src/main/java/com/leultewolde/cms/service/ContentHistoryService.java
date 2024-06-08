package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.ContentHistoryRequestDTO;
import com.leultewolde.cms.dto.response.ContentHistoryResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ContentHistoryService {
    ContentHistoryResponseDTO createContentHistory(ContentHistoryRequestDTO contentHistoryRequestDTO);

    Optional<ContentHistoryResponseDTO> updateContentHistory(Integer changeId, ContentHistoryRequestDTO contentHistoryRequestDTO);

    void deleteContentHistory(Integer changeId);

    Optional<ContentHistoryResponseDTO> getContentHistoryById(Integer changeId);

    List<ContentHistoryResponseDTO> getAllContentHistories();
}
