package com.polli.gustavo.devpoc.modules.permission.entity;

import com.polli.gustavo.devpoc.common.entity.BaseEntity;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Permission extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<User> users;
}
