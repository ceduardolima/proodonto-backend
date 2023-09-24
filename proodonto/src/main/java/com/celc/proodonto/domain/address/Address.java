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
    private String city;
    private String CEP;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.state = addressDTO.state();
        this.city = addressDTO.city();
        this.CEP = addressDTO.CEP();
    }

    public void update(AddressDTO addressDTO) {
        if (addressDTO.street() != null)
            street = addressDTO.street();
        if (addressDTO.neighborhood() != null)
            neighborhood = addressDTO.neighborhood();
        if (addressDTO.state() != null)
            state = addressDTO.state();
        if (addressDTO.city() != null)
            city = addressDTO.city();
        if (addressDTO.CEP() != null)
            CEP = addressDTO.CEP();
    }
}
