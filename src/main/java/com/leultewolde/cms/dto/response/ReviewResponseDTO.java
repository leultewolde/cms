package com.leultewolde.cms.dto.response;

import com.leultewolde.cms.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private Integer reviewId;
    private String feedback;
    private ReviewStatus status;
    private Integer reviewedByUserId;
    private Integer contentId;
}
