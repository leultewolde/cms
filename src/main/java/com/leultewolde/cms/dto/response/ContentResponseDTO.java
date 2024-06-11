package com.leultewolde.cms.dto.response;

import com.leultewolde.cms.model.enums.ContentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponseDTO {
    private Integer contentId;
    private String type;
    private String data;
    private String version;
    private ContentStatus status;
    private UserResponseDTO createdBy;
    private TaskResponseDTO belongsTo;
    private List<ReviewResponseDTO> reviews;
}
