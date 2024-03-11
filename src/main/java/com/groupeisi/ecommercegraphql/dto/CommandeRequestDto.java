package com.groupeisi.ecommercegraphql.dto;


import com.groupeisi.ecommercegraphql.entities.LigneCommande;

import java.sql.Date;
import java.util.List;

public record CommandeRequestDto(
        Long id,
        Date dateCommande,
        Long idClient,
        List<LigneCommande> ligneCommandes
) {
}
