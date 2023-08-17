package com.richards.loginAuthentication.services;

import com.richards.loginAuthentication.dto.requests.LoginRequest;
import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.LoginResponse;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.models.User;
import com.richards.loginAuthentication.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

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


        userRepository.save(user);

        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("Registration successful");
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<User> foundUser = userRepository.findUserByEmail(email);
        foundUser.orElseThrow(() -> new UserNotFoundException(String.format("USER_WITH_EMAIL_NOT_FOUND", email)));

        return null;
    }
}
