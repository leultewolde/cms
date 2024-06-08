package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.ContentRequestDTO;
import com.leultewolde.cms.dto.response.ContentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ContentService {
    ContentResponseDTO createContent(ContentRequestDTO contentRequestDTO);

    Optional<ContentResponseDTO> updateContent(Integer contentId, ContentRequestDTO contentRequestDTO);

    void deleteContent(Integer contentId);

    Optional<ContentResponseDTO> getContentById(Integer contentId);

    List<ContentResponseDTO> getAllContents();
}
