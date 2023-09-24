package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;

public record UserDetailData(
        Long id,
        String name,
        String email,
        String cpf,
        String issuingAgency,
        String birthday,
        String phoneNumber,
        UserType userType,
        AddressDTO address,
        String nationality,
        String placeOfBirth,
        SkinColor skinColor,
        MaritalStatus maritalStatus

) {
    public UserDetailData(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getIssuingAgency(),
                user.getBirthday(),
                user.getPhoneNumber(),
                user.getUserType(),
                new AddressDTO(user.getAddress()),
                user.getNationality(),
                user.getPlaceOfBirth(),
                user.getSkinColor(),
                user.getMaritalStatus()
        );
    }
}
