package com.leultewolde.cms.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, RequestDTO, ResponseDTO> {
    ResponseDTO toDTO(E entity);

    E toEntity(RequestDTO dto);

    List<ResponseDTO> toDTO(List<E> entities);

    List<E> toEntity(List<RequestDTO> dtoList);

    void updateEntityFromDTO(RequestDTO dto, @MappingTarget E entity);
}
