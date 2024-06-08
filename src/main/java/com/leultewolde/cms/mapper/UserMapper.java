package com.leultewolde.cms.mapper;

import com.leultewolde.cms.dto.request.UserRequestDTO;
import com.leultewolde.cms.dto.response.UserResponseDTO;
import com.leultewolde.cms.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserRequestDTO, UserResponseDTO> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}