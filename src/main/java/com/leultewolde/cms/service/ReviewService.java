package com.leultewolde.cms.service;

import com.leultewolde.cms.dto.request.ReviewRequestDTO;
import com.leultewolde.cms.dto.response.ReviewResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO);

    Optional<ReviewResponseDTO> updateReview(Integer reviewId, ReviewRequestDTO reviewRequestDTO);

    void deleteReview(Integer reviewId);

    Optional<ReviewResponseDTO> getReviewById(Integer reviewId);

    List<ReviewResponseDTO> getAllReviews();
}
