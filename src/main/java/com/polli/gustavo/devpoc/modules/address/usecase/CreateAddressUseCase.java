package com.polli.gustavo.devpoc.modules.address.usecase;

import com.polli.gustavo.devpoc.modules.address.dto.AddressDTO;
import com.polli.gustavo.devpoc.modules.address.entity.Address;
import com.polli.gustavo.devpoc.modules.address.mapper.AddressMapper;
import com.polli.gustavo.devpoc.modules.address.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAddressUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public Address execute(AddressDTO addressDTO) {
        Address address = addressMapper.toAddress(addressDTO);
        return addressRepository.save(address);
    }
}