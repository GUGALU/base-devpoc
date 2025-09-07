package com.polli.gustavo.devpoc.modules.permission.usecase;

import com.polli.gustavo.devpoc.modules.permission.dto.PermissionDTO;
import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import com.polli.gustavo.devpoc.modules.permission.mapper.PermissionMapper;
import com.polli.gustavo.devpoc.modules.permission.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePermissionUseCase {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public Permission execute(Long id, PermissionDTO permissionDTO) {
        Permission permission = permissionMapper.toPermission(permissionDTO);
        permission.setId(id);
        return permissionRepository.save(permission);
    }
}