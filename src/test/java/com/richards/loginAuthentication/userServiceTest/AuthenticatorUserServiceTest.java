package com.richards.loginAuthentication.userServiceTest;

import com.richards.loginAuthentication.dto.requests.LoginRequest;
import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.models.User;
import com.richards.loginAuthentication.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")

public class AuthenticatorUserServiceTest {

    @Autowired

    private UserService userService;

    @BeforeEach
    void setUp(){
        User user = new  User();

    }

    @Test
    void testThatUserCanRegister(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstname("Richie");
        registrationRequest.setLastname("Chris");
        registrationRequest.setPassword("password");
        registrationRequest.setEmail("rich@gmail.com");


        assertThat(registrationRequest).isNotNull();

        RegistrationResponse registeredUser = userService.register(registrationRequest);
        assertThat(registeredUser.getMessage()).isEqualTo("Registration successful");

    }

    @Test
    void testThatUserCanLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("rich@gmail.com");
        loginRequest.setPassword("password");

    }
}
