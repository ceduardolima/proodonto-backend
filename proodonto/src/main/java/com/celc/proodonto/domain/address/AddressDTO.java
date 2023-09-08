package com.celc.proodonto.domain.address;

public record AddressDTO(
        String street,
        String neighborhood,
        String city,
        String state,
        String CEP
) {
}
