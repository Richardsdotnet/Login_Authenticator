package com.richards.loginAuthentication.services;

import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;

public interface UserService {
    RegistrationResponse register(RegistrationRequest registrationRequest);
}
