package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.CommandeRequestDto;
import com.groupeisi.ecommercegraphql.entities.Client;
import com.groupeisi.ecommercegraphql.entities.Commande;
import com.groupeisi.ecommercegraphql.mappers.CommandeMapper;
import com.groupeisi.ecommercegraphql.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class CommandeMapperImpl implements CommandeMapper {
    private final IClientService clientService;
    @Override
    public Commande toCommandeEntity(CommandeRequestDto commandeRequestDto) {
        Commande commande =  new Commande();
        commande.setId(commandeRequestDto.id());
        commande.setDateCommande(commandeRequestDto.dateCommande());
        /*@Params idClient
         * return client
         * get client by id from the client service
         */
        Client client = clientService.findById(commandeRequestDto.idClient());
        commande.setClient(client);
        commande.setLigneCommandes(commandeRequestDto.ligneCommandes());
        return commande;
    }

    @Override
    public CommandeRequestDto toCommandeRequestDto(Commande commande) {
        return   new CommandeRequestDto(
                commande.getId(),
                commande.getDateCommande(),
                commande.getClient().getId(),
                commande.getLigneCommandes()
        );
    }
}
