package com.richards.loginAuthentication.services;

import com.richards.loginAuthentication.dto.requests.LoginRequest;
import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.LoginResponse;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.exceptions.BadCredentialsExceptions;
import com.richards.loginAuthentication.exceptions.UserNotFoundException;
import com.richards.loginAuthentication.models.User;
import com.richards.loginAuthentication.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.richards.loginAuthentication.exceptions.ExceptionMessage.INVALID_CREDENTIALS_EXCEPTION;
import static com.richards.loginAuthentication.exceptions.ExceptionMessage.USER_WITH_EMAIL_NOT_FOUND_EXCEPTION;
import static org.springframework.core.io.buffer.DataBufferUtils.matcher;

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
    public LoginResponse login(LoginRequest loginRequest) throws BadCredentialsExceptions {
        LoginResponse response = new LoginResponse();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<User> foundUser = userRepository.findUserByEmail(email);
       User user = foundUser.orElseThrow(() -> new UserNotFoundException(String.format(USER_WITH_EMAIL_NOT_FOUND_EXCEPTION.getMessage(),email)));
        boolean isValidPassword = matcher(user.getPassword(), password);
        if (isValidPassword) return buildLoginResponse();
        throw new BadCredentialsExceptions(INVALID_CREDENTIALS_EXCEPTION.getMessage());

    }

    private LoginResponse buildLoginResponse() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Logged in");
        return loginResponse;
    }

    private boolean matcher(String password1, String password2) {
        return password1.equals(password2);
    }
}
