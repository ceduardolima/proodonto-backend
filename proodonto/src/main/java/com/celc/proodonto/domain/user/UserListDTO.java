package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;

public record UserListDTO(
        String name,
        String email,
        String cpf,
        AddressDTO address
) {
    public UserListDTO(User user) {
        this(user.getName(), user.getEmail(), user.getCpf(), new AddressDTO(user.getAddress()));
    }
}
