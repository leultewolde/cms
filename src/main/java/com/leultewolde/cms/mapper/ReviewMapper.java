package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.ReviewRequestDTO;
import com.leultewolde.cms.dto.response.ReviewResponseDTO;
import com.leultewolde.cms.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends BaseMapper<Review, ReviewRequestDTO, ReviewResponseDTO> {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Override
    @Mapping(source = "reviewedByUserId", target = "reviewedBy.userId")
    @Mapping(source = "contentId", target = "content.contentId")
    Review toEntity(ReviewRequestDTO dto);

    @Override
    @Mapping(source = "reviewedBy.userId", target = "reviewedByUserId")
    @Mapping(source = "content.contentId", target = "contentId")
    ReviewResponseDTO toDTO(Review entity);
}
