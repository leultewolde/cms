package com.leultewolde.cms.mapper;
import com.leultewolde.cms.dto.request.TaskQueueRequestDTO;
import com.leultewolde.cms.dto.response.TaskQueueResponseDTO;
import com.leultewolde.cms.model.TaskQueue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskQueueMapper extends BaseMapper<TaskQueue, TaskQueueRequestDTO, TaskQueueResponseDTO> {
    TaskQueueMapper INSTANCE = Mappers.getMapper(TaskQueueMapper.class);
}

