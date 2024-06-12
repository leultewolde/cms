package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.ContentHistoryRequestDTO;
import com.leultewolde.cms.dto.response.ContentHistoryResponseDTO;
import com.leultewolde.cms.service.ContentHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/content-histories")
@RequiredArgsConstructor
public class ContentHistoryController {

    private final ContentHistoryService contentHistoryService;

    @PostMapping
    public ResponseEntity<ContentHistoryResponseDTO> createContentHistory(@RequestBody ContentHistoryRequestDTO contentHistoryRequestDTO) {
        ContentHistoryResponseDTO createdContentHistory = contentHistoryService.createContentHistory(contentHistoryRequestDTO);
        return ResponseEntity.ok(createdContentHistory);
    }

    @PutMapping("/{changeId}")
    public ResponseEntity<ContentHistoryResponseDTO> updateContentHistory(@PathVariable Integer changeId, @RequestBody ContentHistoryRequestDTO contentHistoryRequestDTO) {
        Optional<ContentHistoryResponseDTO> updatedContentHistory = contentHistoryService.updateContentHistory(changeId, contentHistoryRequestDTO);
        return updatedContentHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{changeId}")
    public ResponseEntity<Void> deleteContentHistory(@PathVariable Integer changeId) {
        contentHistoryService.deleteContentHistory(changeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{changeId}")
    public ResponseEntity<ContentHistoryResponseDTO> getContentHistoryById(@PathVariable Integer changeId) {
        Optional<ContentHistoryResponseDTO> contentHistory = contentHistoryService.getContentHistoryById(changeId);
        return contentHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("content/{contextId}")
    public ResponseEntity<List<ContentHistoryResponseDTO>> getContentHistoryByContentId(@PathVariable Integer contextId) {
        Optional<List<ContentHistoryResponseDTO>> contentHistories = contentHistoryService.getContentHistoryByContentId(contextId);
        return contentHistories.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ContentHistoryResponseDTO>> getContentHistoryByUserId(@PathVariable Integer userId) {
        Optional<List<ContentHistoryResponseDTO>> contentHistories = contentHistoryService.getContentHistoryByUserId(userId);
        return contentHistories.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ContentHistoryResponseDTO>> getAllContentHistories() {
        List<ContentHistoryResponseDTO> contentHistories = contentHistoryService.getAllContentHistories();
        return ResponseEntity.ok(contentHistories);
    }
}
