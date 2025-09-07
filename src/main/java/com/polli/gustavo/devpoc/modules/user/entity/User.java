package com.polli.gustavo.devpoc.modules.user.entity;

import com.polli.gustavo.devpoc.common.entity.BaseEntity;
import com.polli.gustavo.devpoc.modules.address.entity.Address;
import com.polli.gustavo.devpoc.modules.permission.entity.Permission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "TB_USER")
public class User extends BaseEntity {

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
