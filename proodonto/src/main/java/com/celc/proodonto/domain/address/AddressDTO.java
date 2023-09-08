package com.celc.proodonto.domain.address;

public record AddressDTO(
        String street,
        String neighborhood,
        String city,
        String state,
        String CEP
) {
    public AddressDTO(Address address) {
        this(
                address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getState()
        );
    }
}
