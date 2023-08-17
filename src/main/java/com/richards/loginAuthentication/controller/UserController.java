package com.richards.loginAuthentication.controller;

import com.richards.loginAuthentication.dto.requests.RegistrationRequest;
import com.richards.loginAuthentication.dto.response.RegistrationResponse;
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

        @PostMapping
        public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest registerUserRequest) {
            var response = userServices.register(registerUserRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

    }
