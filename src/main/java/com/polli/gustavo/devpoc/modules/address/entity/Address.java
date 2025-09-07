package com.polli.gustavo.devpoc.modules.address.entity;

import com.polli.gustavo.devpoc.common.entity.BaseEntity;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends BaseEntity {

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}