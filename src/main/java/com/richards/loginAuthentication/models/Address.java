package com.richards.loginAuthentication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
public class Address {
    @Id
    private String id;
    private String state;
    private String houseNumber;
    private String StreetNumber;
}
