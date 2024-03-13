package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;

public interface ValidationService {

    void saveValidate(UserDto userDto);
    ValidationDto getValidationByCode(String code);
}
