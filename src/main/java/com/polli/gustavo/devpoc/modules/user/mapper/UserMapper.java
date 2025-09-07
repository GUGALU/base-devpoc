package com.polli.gustavo.devpoc.modules.user.mapper;

import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import com.polli.gustavo.devpoc.modules.user.dto.UserDTO;
import com.polli.gustavo.devpoc.modules.user.dto.UserResponseDTO;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "permissions", expression = "java(toPermissions(userDTO.getPermissions()))")
    User toUser(UserDTO userDTO);

    UserResponseDTO toUserResponseDTO(User user);

    default Set<Permission> toPermissions(Set<Long> permissionIds) {
        return permissionIds.stream()
                .map(id -> {
                    Permission permission = new Permission();
                    permission.setId(id);
                    return permission;
                })
                .collect(Collectors.toSet());
    }
}
