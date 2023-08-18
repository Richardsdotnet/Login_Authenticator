package com.richards.loginAuthentication.controller;

import com.richards.loginAuthentication.dto.requests.LoginRequest;
import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.LoginResponse;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
import com.richards.loginAuthentication.exceptions.BadCredentialsExceptions;
import com.richards.loginAuthentication.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class UserController {




        private final UserService userServices;

        @PostMapping("/register")
        public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest registerUserRequest) {
            RegistrationResponse response = userServices.register(registerUserRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PostMapping("/login")
        public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws BadCredentialsExceptions {
            LoginResponse response = userServices.login(loginRequest);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }
