package com.leultewolde.cms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingPlatformRequestDTO {
    private String platformName;
    private String APIIntegrationDetails;
}
