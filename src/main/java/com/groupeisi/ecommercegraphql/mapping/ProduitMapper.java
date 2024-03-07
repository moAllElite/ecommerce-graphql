package com.groupeisi.ecommercegraphql.mapping;

import com.groupeisi.ecommercegraphql.dto.ProduitDTO;
import com.groupeisi.ecommercegraphql.entities.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {Produit.class})
public interface ProduitMapping {
    Produit toProduitEntity(ProduitDTO produitDTO);
    ProduitDTO toProduitDTO(Produit produit);
}
