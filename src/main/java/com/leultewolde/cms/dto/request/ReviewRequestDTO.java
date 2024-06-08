package com.leultewolde.cms.dto.request;

import com.leultewolde.cms.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    private String feedback;
    private ReviewStatus status;
    private Integer reviewedByUserId;
    private Integer contentId;

    // Getters and Setters
}
