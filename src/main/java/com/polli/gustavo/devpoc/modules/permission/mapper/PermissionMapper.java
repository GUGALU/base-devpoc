package com.polli.gustavo.devpoc.modules.permission.mapper;

import com.polli.gustavo.devpoc.modules.permission.dto.PermissionDTO;
import com.polli.gustavo.devpoc.modules.permission.dto.PermissionResponseDTO;
import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionDTO permissionDTO);

    PermissionResponseDTO toPermissionResponseDTO(Permission permission);
}
