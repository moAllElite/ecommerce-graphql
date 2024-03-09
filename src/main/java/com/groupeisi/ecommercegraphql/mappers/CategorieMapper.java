package com.groupeisi.ecommercegraphql.mappers;


import com.groupeisi.ecommercegraphql.dto.CategorieRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;

//@Mapper(uses = {Categorie.class},componentModel = "spring")

public interface CategorieMapper {
    Categorie toCategorieEntity(CategorieRequestDto categorieRequestDto);
    CategorieRequestDto toCategorieRequestDto(Categorie categorie);
}
