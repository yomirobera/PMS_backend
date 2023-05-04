package com.example.pms.mappers;

import com.example.pms.models.User;
import com.example.pms.models.dto.user.UserDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserDTO userToUserDto(User user);
    public abstract Collection<UserDTO> userToUserDto(Collection<User> users);
}
