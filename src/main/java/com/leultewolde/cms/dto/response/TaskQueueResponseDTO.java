package com.leultewolde.cms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskQueueResponseDTO {
    private Integer queueId;
    private List<Integer> tasksIds;
}
