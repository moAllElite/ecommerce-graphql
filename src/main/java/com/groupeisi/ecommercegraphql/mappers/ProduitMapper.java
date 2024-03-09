package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import org.mapstruct.Mapper;

@Mapper(uses = {Produit.class},componentModel = "spring")
public interface ProduitMapper {
    ProduitRequestDto toProduitRequestDto(Produit produit);
    Produit toProduit(ProduitRequestDto produitRequestDto);
}
