package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record UserData(
        @NotBlank
        String name,
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        UserType userType,
        @NotBlank
        SkinColor skinColor,
        @NotBlank
        String issuingAgency,
        String birthday,
        @NotEmpty
        String phoneNumber,
        @NotBlank
        AddressDTO address,
        String nationality,
        String placeOfBirth,
        MaritalStatus maritalStatus
) {
}
