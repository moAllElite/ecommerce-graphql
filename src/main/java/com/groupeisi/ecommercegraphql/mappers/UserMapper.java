package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.User;

public interface UserMapper {
    User toUserEntity(UserDto userDto);
    UserDto  toUserDto(User user);
}
