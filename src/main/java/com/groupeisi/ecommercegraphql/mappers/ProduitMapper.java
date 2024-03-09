package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;


public interface ProduitMapper {
    ProduitRequestDto toProduitRequestDto(Produit produit);
    Produit toProduitEntity(ProduitRequestDto produitRequestDto);
}
