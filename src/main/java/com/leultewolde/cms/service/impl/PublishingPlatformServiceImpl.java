package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.PublishingPlatformRequestDTO;
import com.leultewolde.cms.dto.response.PublishingPlatformResponseDTO;
import com.leultewolde.cms.mapper.PublishingPlatformMapper;
import com.leultewolde.cms.model.PublishingPlatform;
import com.leultewolde.cms.repository.PublishingPlatformRepository;
import com.leultewolde.cms.service.PublishingPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublishingPlatformServiceImpl implements PublishingPlatformService {

    private final PublishingPlatformRepository publishingPlatformRepository;
    private final PublishingPlatformMapper publishingPlatformMapper;

    @Override
    public PublishingPlatformResponseDTO createPublishingPlatform(PublishingPlatformRequestDTO publishingPlatformRequestDTO) {
        PublishingPlatform publishingPlatform = publishingPlatformMapper.toEntity(publishingPlatformRequestDTO);
        PublishingPlatform savedPublishingPlatform = publishingPlatformRepository.save(publishingPlatform);
        return publishingPlatformMapper.toDTO(savedPublishingPlatform);
    }

    @Override
    public Optional<PublishingPlatformResponseDTO> updatePublishingPlatform(Integer platformId, PublishingPlatformRequestDTO publishingPlatformRequestDTO) {
        return publishingPlatformRepository.findById(platformId)
                .map(existingPublishingPlatform -> {
                    publishingPlatformMapper.updateEntityFromDTO(publishingPlatformRequestDTO, existingPublishingPlatform);
                    return publishingPlatformMapper.toDTO(publishingPlatformRepository.save(existingPublishingPlatform));
                });
    }

    @Override
    public void deletePublishingPlatform(Integer platformId) {
        publishingPlatformRepository.deleteById(platformId);
    }

    @Override
    public Optional<PublishingPlatformResponseDTO> getPublishingPlatformById(Integer platformId) {
        return publishingPlatformRepository.findById(platformId).map(publishingPlatformMapper::toDTO);
    }

    @Override
    public List<PublishingPlatformResponseDTO> getAllPublishingPlatforms() {
        return publishingPlatformMapper.toDTO(publishingPlatformRepository.findAll());
    }
}
