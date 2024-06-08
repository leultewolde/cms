package com.leultewolde.cms.dto.response;

import com.leultewolde.cms.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private Integer taskId;
    private String title;
    private String description;
    private LocalDate deadline;
    private TaskStatus status;
    private List<PublishingPlatformResponseDTO> targetPlatforms;
    private UserResponseDTO assignedTo;
}
