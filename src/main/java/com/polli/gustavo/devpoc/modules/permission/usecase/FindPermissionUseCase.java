package com.polli.gustavo.devpoc.modules.permission.usecase;

import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import com.polli.gustavo.devpoc.modules.permission.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindPermissionUseCase {

    private final PermissionRepository permissionRepository;

    public List<Permission> execute() {
        return permissionRepository.findAll();
    }

    public Permission execute(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }
}
