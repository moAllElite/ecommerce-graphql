package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import jakarta.mail.MessagingException;

public interface ValidationService {

    void saveValidate(UserDto userDto) throws MessagingException;
    ValidationDto getValidationByCode(String code);

}
