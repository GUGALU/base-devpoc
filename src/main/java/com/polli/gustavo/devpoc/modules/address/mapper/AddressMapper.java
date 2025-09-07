package com.polli.gustavo.devpoc.modules.address.mapper;

import com.polli.gustavo.devpoc.modules.address.dto.AddressDTO;
import com.polli.gustavo.devpoc.modules.address.dto.AddressResponseDTO;
import com.polli.gustavo.devpoc.modules.address.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "userId", target = "user.id")
    Address toAddress(AddressDTO addressDTO);

    AddressResponseDTO toAddressResponseDTO(Address address);
}
