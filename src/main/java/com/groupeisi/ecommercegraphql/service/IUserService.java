package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.User;

import java.util.Optional;

public interface IUserService {
    void saveUserEntity(User user);
    void save(UserDto userDto);
    void delete(Long id);
    Optional<UserDto> findByEmail(String email);

}
