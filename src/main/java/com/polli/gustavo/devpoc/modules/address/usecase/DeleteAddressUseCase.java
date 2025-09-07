package com.polli.gustavo.devpoc.modules.address.usecase;

import com.polli.gustavo.devpoc.modules.address.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAddressUseCase {

    private final AddressRepository addressRepository;

    public void execute(Long id) {
        addressRepository.deleteById(id);
    }
}
