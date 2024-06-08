package com.leultewolde.cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publishing-platforms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishingPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;

    private String platformName;
    private String APIIntegrationDetails;
}

