package com.groupeisi.ecommercegraphql.mappers.impl;


import com.groupeisi.ecommercegraphql.dto.UserDto;
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
       return  User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .nom(userDto.getNom())
                .password(userDto.getPassword())
                .role(roleMapper.toRoleEntity(userDto.getRoleDto()))
                .actived(userDto.getActived() != null && userDto.getActived())
                .build();
    }

    @Override
    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .email(user.getEmail())
                .password(user.getPassword())
                .actived(user.isActived())
                .roleDto(roleMapper.toRoleDto(user.getRole()))
                .build();
    }
}
