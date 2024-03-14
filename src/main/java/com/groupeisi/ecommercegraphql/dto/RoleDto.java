package com.groupeisi.ecommercegraphql.dto;


import com.groupeisi.ecommercegraphql.entities.TypeDeRole;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private TypeDeRole libelle;
}
