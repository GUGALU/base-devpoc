package com.polli.gustavo.devpoc.modules.user.dto;

import com.polli.gustavo.devpoc.modules.address.dto.AddressResponseDTO;
import com.polli.gustavo.devpoc.modules.permission.dto.PermissionResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<AddressResponseDTO> addresses;
    private Set<PermissionResponseDTO> permissions;
}
