package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;

import java.util.Map;
import java.util.Optional;

public interface IUserService {
    void save(UserDto userDto);
    void delete(Long id);
    Optional<UserDto> findByEmail(String email);
    Optional<UserDto> findById(Long id);

    void activation(Map<String, String> activation);
}
