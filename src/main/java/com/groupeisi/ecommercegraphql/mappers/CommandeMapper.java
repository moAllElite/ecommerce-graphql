package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.CommandeRequestDto;
import com.groupeisi.ecommercegraphql.entities.Commande;

public interface CommandeMapper {
    Commande toCommandeEntity(CommandeRequestDto commandeRequestDto);
    CommandeRequestDto toCommandeRequestDto(Commande commande);
}
