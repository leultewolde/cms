package com.leultewolde.cms.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskQueueRequestDTO {
    private Integer userId;
    private List<Integer> taskIds;
}

