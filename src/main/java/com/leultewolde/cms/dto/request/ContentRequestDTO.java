package com.leultewolde.cms.dto.request;

import com.leultewolde.cms.enums.ContentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentRequestDTO {
    private String type;
    private String data;
    private String version;
    private ContentStatus status;
    private Integer createdByUserId;
    private Integer taskId;
}
