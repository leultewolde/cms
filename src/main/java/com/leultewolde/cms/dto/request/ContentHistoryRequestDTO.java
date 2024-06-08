package com.leultewolde.cms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentHistoryRequestDTO {
    private LocalDate changeDate;
    private String changeDescription;
    private Integer contentId;
    private Integer modifiedByUserId;

    // Getters and Setters
}
