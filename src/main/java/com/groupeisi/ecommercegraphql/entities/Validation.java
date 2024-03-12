package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Validation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant creation;
    private Instant expiration;
    private String activation;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private User    user;
}
