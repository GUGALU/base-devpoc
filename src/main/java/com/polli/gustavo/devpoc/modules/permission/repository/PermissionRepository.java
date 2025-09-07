package com.polli.gustavo.devpoc.modules.permission.repository;

import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
