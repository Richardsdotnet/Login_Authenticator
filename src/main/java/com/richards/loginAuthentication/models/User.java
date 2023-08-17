package com.richards.loginAuthentication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity

public class User {
   @Id
    private String id;

    private String firstname;
    private String lastname;
    private String password;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Address address;
    private String email;

}
