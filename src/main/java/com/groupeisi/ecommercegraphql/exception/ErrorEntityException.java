package com.groupeisi.ecommercegraphql.exception;

import org.springframework.http.HttpStatus;

public record ErrorEntityException(
        HttpStatus code,
        String message
) {
}
