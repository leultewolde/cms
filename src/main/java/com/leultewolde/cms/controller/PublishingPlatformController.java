package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.PublishingPlatformRequestDTO;
import com.leultewolde.cms.dto.response.PublishingPlatformResponseDTO;
import com.leultewolde.cms.service.PublishingPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishing-platforms")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMINISTRATOR')")
public class PublishingPlatformController {

    private final PublishingPlatformService publishingPlatformService;

    @PostMapping
    public ResponseEntity<PublishingPlatformResponseDTO> createPublishingPlatform(@RequestBody PublishingPlatformRequestDTO publishingPlatformRequestDTO) {
        PublishingPlatformResponseDTO createdPublishingPlatform = publishingPlatformService.createPublishingPlatform(publishingPlatformRequestDTO);
        return ResponseEntity.ok(createdPublishingPlatform);
    }

    @PutMapping("/{platformId}")
    public ResponseEntity<PublishingPlatformResponseDTO> updatePublishingPlatform(@PathVariable Integer platformId, @RequestBody PublishingPlatformRequestDTO publishingPlatformRequestDTO) {
        Optional<PublishingPlatformResponseDTO> updatedPublishingPlatform = publishingPlatformService.updatePublishingPlatform(platformId, publishingPlatformRequestDTO);
        return updatedPublishingPlatform.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{platformId}")
    public ResponseEntity<Void> deletePublishingPlatform(@PathVariable Integer platformId) {
        publishingPlatformService.deletePublishingPlatform(platformId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{platformId}")
    public ResponseEntity<PublishingPlatformResponseDTO> getPublishingPlatformById(@PathVariable Integer platformId) {
        Optional<PublishingPlatformResponseDTO> publishingPlatform = publishingPlatformService.getPublishingPlatformById(platformId);
        return publishingPlatform.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PublishingPlatformResponseDTO>> getAllPublishingPlatforms() {
        List<PublishingPlatformResponseDTO> publishingPlatforms = publishingPlatformService.getAllPublishingPlatforms();
        return ResponseEntity.ok(publishingPlatforms);
    }
}
