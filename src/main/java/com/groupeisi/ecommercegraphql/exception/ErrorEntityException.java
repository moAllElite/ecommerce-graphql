package com.groupeisi.ecommercegraphql.exception;

import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;

public record ErrorEntityException(
        HttpStatus code,

        String message,
        LocalDateTime timeStamp
) {
}
