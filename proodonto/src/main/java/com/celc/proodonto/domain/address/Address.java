package com.celc.proodonto.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String state;
    private String CEP;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = this.getNeighborhood();
        this.state = this.getState();
        this.CEP = this.getCEP();
    }
}
