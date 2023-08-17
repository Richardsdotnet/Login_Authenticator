package com.richards.loginAuthentication.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationRequest {
    private String email;
    private String firstname;
    private String lastname;
    private String password;


}
