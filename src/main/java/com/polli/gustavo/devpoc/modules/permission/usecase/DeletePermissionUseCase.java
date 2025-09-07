package com.polli.gustavo.devpoc.modules.permission.usecase;

import com.polli.gustavo.devpoc.modules.permission.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePermissionUseCase {

    private final PermissionRepository permissionRepository;

    public void execute(Long id) {
        permissionRepository.deleteById(id);
    }
}
