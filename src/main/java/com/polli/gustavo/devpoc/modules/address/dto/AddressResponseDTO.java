package com.polli.gustavo.devpoc.modules.address.dto;

import lombok.Data;

@Data
public class AddressResponseDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
