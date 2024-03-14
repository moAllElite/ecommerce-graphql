package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses={User.class})
public interface UserMapper {
    User toUserEntity(UserDto userDto);
    UserDto  toUserDto(User user);
}
