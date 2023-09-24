package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String issuingAgency;
    private String birthday;
    private String phoneNumber;
    @Embedded
    private Address address;
    private String nationality;
    private String placeOfBirth;

    @Enumerated(EnumType.STRING)
    private SkinColor skinColor;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    public User(@Valid UserData data) {
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.skinColor = data.skinColor();
        this.issuingAgency = data.issuingAgency();
        this.birthday = data.birthday();
        this.phoneNumber = data.phoneNumber();
        this.userType = data.userType();
        this.address = new Address(data.address());
        this.nationality = data.nationality();
        this.placeOfBirth = data.placeOfBirth();
        this.maritalStatus = data.maritalStatus();
    }

    public void update(UserUpdateData userUpdateData) {
        if (userUpdateData.name() != null)
            name = userUpdateData.name();
        if (userUpdateData.phoneNumber() != null)
            phoneNumber = userUpdateData.phoneNumber();
        if (userUpdateData.address() != null)
            address.update(userUpdateData.address());
        if (userUpdateData.maritalStatus() != null)
            maritalStatus = userUpdateData.maritalStatus();
    }
}
