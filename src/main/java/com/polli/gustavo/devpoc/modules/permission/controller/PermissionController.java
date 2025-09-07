package com.polli.gustavo.devpoc.modules.permission.controller;

import com.polli.gustavo.devpoc.modules.permission.dto.PermissionDTO;
import com.polli.gustavo.devpoc.modules.permission.dto.PermissionResponseDTO;
import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import com.polli.gustavo.devpoc.modules.permission.mapper.PermissionMapper;
import com.polli.gustavo.devpoc.modules.permission.usecase.CreatePermissionUseCase;
import com.polli.gustavo.devpoc.modules.permission.usecase.DeletePermissionUseCase;
import com.polli.gustavo.devpoc.modules.permission.usecase.FindPermissionUseCase;
import com.polli.gustavo.devpoc.modules.permission.usecase.UpdatePermissionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permission")
@AllArgsConstructor
public class PermissionController {

    private final CreatePermissionUseCase createPermissionUseCase;
    private final FindPermissionUseCase findPermissionUseCase;
    private final UpdatePermissionUseCase updatePermissionUseCase;
    private final DeletePermissionUseCase deletePermissionUseCase;
    private final PermissionMapper permissionMapper;

    @PostMapping
    public PermissionResponseDTO create(@RequestBody PermissionDTO permissionDTO) {
        Permission permission = createPermissionUseCase.execute(permissionDTO);
        return permissionMapper.toPermissionResponseDTO(permission);
    }

    @GetMapping
    public List<PermissionResponseDTO> find() {
        return findPermissionUseCase.execute().stream()
                .map(permissionMapper::toPermissionResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PermissionResponseDTO findById(@PathVariable Long id) {
        Permission permission = findPermissionUseCase.execute(id);
        return permissionMapper.toPermissionResponseDTO(permission);
    }

    @PutMapping("/{id}")
    public PermissionResponseDTO update(@PathVariable Long id, @RequestBody PermissionDTO permissionDTO) {
        Permission permission = updatePermissionUseCase.execute(id, permissionDTO);
        return permissionMapper.toPermissionResponseDTO(permission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePermissionUseCase.execute(id);
    }
}