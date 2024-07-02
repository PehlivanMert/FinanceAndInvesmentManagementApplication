package dev.pehlivan.financeandinvesmentmanagementapplication.mapper;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.UserDto;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
