package com.polli.gustavo.devpoc.modules.address.usecase;

import com.polli.gustavo.devpoc.modules.address.entity.Address;
import com.polli.gustavo.devpoc.modules.address.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAddressUseCase {

    private final AddressRepository addressRepository;

    public List<Address> execute() {
        return addressRepository.findAll();
    }

    public Address execute(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
