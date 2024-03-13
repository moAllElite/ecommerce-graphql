package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Builder
@Setter
@AllArgsConstructor
public class Validation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private User    user;
}
