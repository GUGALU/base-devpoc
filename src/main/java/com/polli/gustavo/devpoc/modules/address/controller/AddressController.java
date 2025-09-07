package com.polli.gustavo.devpoc.modules.address.controller;

import com.polli.gustavo.devpoc.modules.address.dto.AddressDTO;
import com.polli.gustavo.devpoc.modules.address.dto.AddressResponseDTO;
import com.polli.gustavo.devpoc.modules.address.entity.Address;
import com.polli.gustavo.devpoc.modules.address.mapper.AddressMapper;
import com.polli.gustavo.devpoc.modules.address.usecase.CreateAddressUseCase;
import com.polli.gustavo.devpoc.modules.address.usecase.DeleteAddressUseCase;
import com.polli.gustavo.devpoc.modules.address.usecase.FindAddressUseCase;
import com.polli.gustavo.devpoc.modules.address.usecase.UpdateAddressUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final CreateAddressUseCase createAddressUseCase;
    private final FindAddressUseCase findAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;
    private final AddressMapper addressMapper;

    @PostMapping
    public AddressResponseDTO create(@RequestBody AddressDTO addressDTO) {
        Address address = createAddressUseCase.execute(addressDTO);
        return addressMapper.toAddressResponseDTO(address);
    }

    @GetMapping
    public List<AddressResponseDTO> find() {
        return findAddressUseCase.execute().stream()
                .map(addressMapper::toAddressResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AddressResponseDTO findById(@PathVariable Long id) {
        Address address = findAddressUseCase.execute(id);
        return addressMapper.toAddressResponseDTO(address);
    }

    @PutMapping("/{id}")
    public AddressResponseDTO update(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        Address address = updateAddressUseCase.execute(id, addressDTO);
        return addressMapper.toAddressResponseDTO(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteAddressUseCase.execute(id);
    }
}