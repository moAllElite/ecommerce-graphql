package com.groupeisi.ecommercegraphql.dto;


import com.groupeisi.ecommercegraphql.entities.TypeDeRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private TypeDeRole libelle;
}
