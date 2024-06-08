package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.PublishingPlatformRequestDTO;
import com.leultewolde.cms.dto.response.PublishingPlatformResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PublishingPlatformService {
    PublishingPlatformResponseDTO createPublishingPlatform(PublishingPlatformRequestDTO publishingPlatformRequestDTO);

    Optional<PublishingPlatformResponseDTO> updatePublishingPlatform(Integer platformId, PublishingPlatformRequestDTO publishingPlatformRequestDTO);

    void deletePublishingPlatform(Integer platformId);

    Optional<PublishingPlatformResponseDTO> getPublishingPlatformById(Integer platformId);

    List<PublishingPlatformResponseDTO> getAllPublishingPlatforms();
}
