package com.richards.loginAuthentication.userServiceTest;

import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.models.User;
import com.richards.loginAuthentication.services.AuthenticatorUserService;
import com.richards.loginAuthentication.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

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
        registrationRequest.setState("Lagos");
        registrationRequest.setHouseNumber("No10");
        registrationRequest.setStreetNumber("No2");

        assertThat(registrationRequest).isNotNull();

        RegistrationResponse registeredUser = userService.register(registrationRequest);
        assertThat(registeredUser.getMessage()).isEqualTo("Registration successful");

    }
}