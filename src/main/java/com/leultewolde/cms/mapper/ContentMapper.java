package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.ContentRequestDTO;
import com.leultewolde.cms.dto.response.ContentResponseDTO;
import com.leultewolde.cms.model.Content;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContentMapper extends BaseMapper<Content, ContentRequestDTO, ContentResponseDTO> {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    @Override
    @Mapping(source = "createdByUserId", target = "createdBy.userId")
    @Mapping(source = "taskId", target = "belongsTo.taskId")
    Content toEntity(ContentRequestDTO dto);

    @Override
    @Mapping(source = "createdBy.userId", target = "createdBy.userId")
    @Mapping(source = "belongsTo.taskId", target = "belongsTo.taskId")
    ContentResponseDTO toDTO(Content entity);
}
