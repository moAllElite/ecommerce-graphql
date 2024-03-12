package com.groupeisi.ecommercegraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ValidationDto {
    private Instant creation;
    private Instant expiration;
    private String activation;
    private String code;
    private Long userId;
}
