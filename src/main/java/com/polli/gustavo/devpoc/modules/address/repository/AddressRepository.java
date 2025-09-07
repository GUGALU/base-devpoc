package com.polli.gustavo.devpoc.modules.address.repository;

import com.polli.gustavo.devpoc.modules.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
