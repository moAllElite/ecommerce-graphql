package com.groupeisi.ecommercegraphql.dto;

public record ClientRequestDto(
        Long id,
        String nomComplet,
        String adresse,
        String telephone
) {
}
