package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.TaskRequestDTO;
import com.leultewolde.cms.dto.response.TaskResponseDTO;
import com.leultewolde.cms.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<Task, TaskRequestDTO, TaskResponseDTO> {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Override
    @Mapping(source = "assignedToUserId", target = "assignedTo.userId")
    Task toEntity(TaskRequestDTO dto);

    @Override
    @Mapping(source = "assignedTo.userId", target = "assignedToUserId")
    TaskResponseDTO toDTO(Task entity);
}
