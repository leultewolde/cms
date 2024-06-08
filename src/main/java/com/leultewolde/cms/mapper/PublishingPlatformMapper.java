package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.PublishingPlatformRequestDTO;
import com.leultewolde.cms.dto.response.PublishingPlatformResponseDTO;
import com.leultewolde.cms.model.PublishingPlatform;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublishingPlatformMapper extends BaseMapper<PublishingPlatform, PublishingPlatformRequestDTO, PublishingPlatformResponseDTO> {
    PublishingPlatformMapper INSTANCE = Mappers.getMapper(PublishingPlatformMapper.class);
}
