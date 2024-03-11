package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.entities.Role;
import com.groupeisi.ecommercegraphql.mappers.RoleMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public Role toRoleEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setLibelle(roleDto.getLibelle());
        return role;
    }

    @Override
    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setLibelle(role.getLibelle());
        return roleDto;
    }
}
