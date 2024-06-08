package com.leultewolde.cms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingPlatformResponseDTO {
    private Integer platformId;
    private String platformName;
    private String APIIntegrationDetails;

    // Getters and Setters
}
