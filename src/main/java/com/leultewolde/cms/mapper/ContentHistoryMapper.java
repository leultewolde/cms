package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.ContentHistoryRequestDTO;
import com.leultewolde.cms.dto.response.ContentHistoryResponseDTO;
import com.leultewolde.cms.model.ContentHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContentHistoryMapper extends BaseMapper<ContentHistory, ContentHistoryRequestDTO, ContentHistoryResponseDTO> {
    ContentHistoryMapper INSTANCE = Mappers.getMapper(ContentHistoryMapper.class);

    @Override
    @Mapping(source = "contentId", target = "content.contentId")
    @Mapping(source = "modifiedByUserId", target = "modifiedBy.userId")
    ContentHistory toEntity(ContentHistoryRequestDTO dto);

    @Override
    @Mapping(source = "content.contentId", target = "content.contentId")
    @Mapping(source = "modifiedBy.userId", target = "modifiedBy.userId")
    ContentHistoryResponseDTO toDTO(ContentHistory entity);
}
