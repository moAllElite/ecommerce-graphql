package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.entities.Role;

public interface RoleMapper {
    Role toRoleEntity(RoleDto roleDto);
    RoleDto toRoleDto(Role role);
}
