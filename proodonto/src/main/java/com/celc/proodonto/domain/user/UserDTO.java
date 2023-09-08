package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UserDTO(
        @NotBlank
        String name,
        String email,
        @NotBlank
        String cpf,
        UserType userType,
        SkinColor skinColor,
        String issuingAgency,
        String birthday,
        String phoneNumber,
        AddressDTO address,
        String nationality,
        String placeOfBirth,
        MaritalStatus maritalStatus
) {
}
