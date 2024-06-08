package com.leultewolde.cms.dto.request;

import com.leultewolde.cms.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private LocalDate deadline;
    private TaskStatus status;
    private List<Integer> targetPlatformIds;
    private Integer assignedToUserId;
}
