package com.celc.proodonto.domain.user;

import com.celc.proodonto.domain.address.Address;
import com.celc.proodonto.domain.address.AddressDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private String cpf;
    private UserType userType;
    private SkinColor skinColor;
    private String issuingAgency;
    private Date birthday;
    private String phoneNumber;
    @Embedded
    private Address address;
    private String nationality;
    private String placeOfBirth;
    private MaritalStatus maritalStatus;
    public User(@Valid UserDTO data) {
        this.name = data.name();
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
}
