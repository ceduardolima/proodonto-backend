package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long id,
        String name,
        String email,
        String phoneNumber,
        AddressDTO address,
        MaritalStatus maritalStatus

) {
}
