package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.ContentRequestDTO;
import com.leultewolde.cms.dto.response.ContentResponseDTO;
import com.leultewolde.cms.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    @PreAuthorize("hasAuthority('contributor:write')")
    public ResponseEntity<ContentResponseDTO> createContent(@RequestBody ContentRequestDTO contentRequestDTO) {
        ContentResponseDTO createdContent = contentService.createContent(contentRequestDTO);
        return ResponseEntity.ok(createdContent);
    }

    @PutMapping("/{contentId}")
    @PreAuthorize("hasAnyAuthority('admin:read','admin:write','contributor:read','contributor:write','reviewer:read','reviewer:write')")
    public ResponseEntity<ContentResponseDTO> updateContent(@PathVariable Integer contentId, @RequestBody ContentRequestDTO contentRequestDTO) {
        Optional<ContentResponseDTO> updatedContent = contentService.updateContent(contentId, contentRequestDTO);
        return updatedContent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{contentId}")
    @PreAuthorize("hasAuthority('contributor:write')")
    public ResponseEntity<Void> deleteContent(@PathVariable Integer contentId) {
        contentService.deleteContent(contentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ContentResponseDTO> getContentById(@PathVariable Integer contentId) {
        Optional<ContentResponseDTO> content = contentService.getContentById(contentId);
        return content.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ContentResponseDTO>> getAllContents() {
        List<ContentResponseDTO> contents = contentService.getAllContents();
        return ResponseEntity.ok(contents);
    }
}
