package com.celc.proodonto.domain.address;

public record AddressDTO(
        String street,
        String neighborhood,
        String state,
        String CEP
) {
}
