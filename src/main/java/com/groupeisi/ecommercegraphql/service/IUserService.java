package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.TypeDeRole;

import java.util.Map;
import java.util.Optional;

public interface IUserService {
    Long save(TypeDeRole roleName, UserDto userDto);
    void delete(Long id);
    Optional<UserDto> findByEmail(String email);
    Optional<UserDto> findById(Long id);
    void activation(Map<String, String> activation);
}
