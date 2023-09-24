package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.AddressDTO;

public record UserListData(
        Long id,
        String name,
        String email,
        String cpf,
        AddressDTO address
) {
    public UserListData(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getCpf(), new AddressDTO(user.getAddress()));
    }
}
