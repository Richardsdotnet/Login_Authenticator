package com.richards.loginAuthentication.services;

import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.models.Address;
import com.richards.loginAuthentication.models.User;
import com.richards.loginAuthentication.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class AuthenticatorUserService implements UserService{
    private UserRepository userRepository;
    @Override
    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        String email = registrationRequest.getEmail();
        String password = registrationRequest.getPassword();
        String firstName = registrationRequest.getFirstname();
        String lastName = registrationRequest.getLastname();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setAddress(new Address());

        userRepository.save(user);

        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("Registration successful");
        return response;
    }
}
