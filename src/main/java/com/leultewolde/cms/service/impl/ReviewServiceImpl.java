package com.leultewolde.cms.service.impl;

import com.leultewolde.cms.dto.request.ReviewRequestDTO;
import com.leultewolde.cms.dto.response.ReviewResponseDTO;
import com.leultewolde.cms.mapper.ReviewMapper;
import com.leultewolde.cms.model.Content;
import com.leultewolde.cms.model.Review;
import com.leultewolde.cms.model.User;
import com.leultewolde.cms.repository.ContentRepository;
import com.leultewolde.cms.repository.ReviewRepository;
import com.leultewolde.cms.repository.UserRepository;
import com.leultewolde.cms.service.ReviewService;
import com.leultewolde.cms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewMapper.toEntity(reviewRequestDTO);
        User reviewedBy = userRepository.findById(reviewRequestDTO.getReviewedByUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Content content = contentRepository.findById(reviewRequestDTO.getContentId())
                .orElseThrow(() -> new ResourceNotFoundException("Content not found"));
        review.setReviewedBy(reviewedBy);
        review.setContent(content);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDTO(savedReview);
    }

    @Override
    public Optional<ReviewResponseDTO> updateReview(Integer reviewId, ReviewRequestDTO reviewRequestDTO) {
        return reviewRepository.findById(reviewId)
                .map(existingReview -> {
                    reviewMapper.updateEntityFromDTO(reviewRequestDTO, existingReview);
                    User reviewedBy = userRepository.findById(reviewRequestDTO.getReviewedByUserId())
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                    Content content = contentRepository.findById(reviewRequestDTO.getContentId())
                            .orElseThrow(() -> new ResourceNotFoundException("Content not found"));
                    existingReview.setReviewedBy(reviewedBy);
                    existingReview.setContent(content);
                    return reviewMapper.toDTO(reviewRepository.save(existingReview));
                });
    }

    @Override
    public void deleteReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Optional<ReviewResponseDTO> getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId).map(reviewMapper::toDTO);
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewMapper.toDTO(reviewRepository.findAll());
    }
}
