package com.polli.gustavo.devpoc.modules.permission.usecase;

import com.polli.gustavo.devpoc.modules.permission.dto.PermissionDTO;
import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import com.polli.gustavo.devpoc.modules.permission.mapper.PermissionMapper;
import com.polli.gustavo.devpoc.modules.permission.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatePermissionUseCase {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public Permission execute(PermissionDTO permissionDTO) {
        Permission permission = permissionMapper.toPermission(permissionDTO);
        return permissionRepository.save(permission);
    }
}