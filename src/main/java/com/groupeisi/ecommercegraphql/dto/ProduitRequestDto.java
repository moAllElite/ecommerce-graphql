package com.groupeisi.ecommercegraphql.dto;


public record ProduitRequestDto(
        String  idProduit,
        String designation,
        String description,
        double prix,
        int quantite,
        boolean selectionne,
         String photo,

        Long categorieId
) {
   
}
