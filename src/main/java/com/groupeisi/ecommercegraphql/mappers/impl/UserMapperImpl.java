package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.Role;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.mappers.RoleMapper;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {
    private final RoleMapper roleMapper;
    @Override
    public User toUserEntity(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setId(userDto.getId());
        RoleDto role = userDto.getRoleDto();
        user.setRole(roleMapper.toRoleEntity(role));

        return user;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setId(user.getId());
        userDto.setActived(user.isActived());
        Role r = user.getRole();
        userDto.setRoleDto(roleMapper.toRoleDto(r));
        return userDto;
    }
}
