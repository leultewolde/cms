package com.leultewolde.cms.controller;

import com.leultewolde.cms.dto.request.ReviewRequestDTO;
import com.leultewolde.cms.dto.response.ReviewResponseDTO;
import com.leultewolde.cms.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @PreAuthorize("hasAuthority('reviewer:write')")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        ReviewResponseDTO createdReview = reviewService.createReview(reviewRequestDTO);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{reviewId}")
    @PreAuthorize("hasAuthority('reviewer:write')")
    public ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable Integer reviewId, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        Optional<ReviewResponseDTO> updatedReview = reviewService.updateReview(reviewId, reviewRequestDTO);
        return updatedReview.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{reviewId}")
    @PreAuthorize("hasAuthority('reviewer:write')")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable Integer reviewId) {
        Optional<ReviewResponseDTO> review = reviewService.getReviewById(reviewId);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        List<ReviewResponseDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
}
