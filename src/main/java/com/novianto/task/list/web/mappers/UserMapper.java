package com.novianto.task.list.web.mappers;

import com.novianto.task.list.domain.user.User;
import com.novianto.task.list.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
