package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;

public interface ValidationService {

    void saveValidate(UserDto userDto);
}
