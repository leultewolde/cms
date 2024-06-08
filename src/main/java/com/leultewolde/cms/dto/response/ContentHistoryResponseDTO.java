package com.leultewolde.cms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentHistoryResponseDTO {
    private Integer changeId;
    private LocalDate changeDate;
    private String changeDescription;
    private ContentResponseDTO content;
    private UserResponseDTO modifiedBy;
}
