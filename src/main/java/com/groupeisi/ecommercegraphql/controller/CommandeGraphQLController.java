package com.groupeisi.ecommercegraphql.controller;

import com.groupeisi.ecommercegraphql.dto.CommandeRequestDto;
import com.groupeisi.ecommercegraphql.entities.Commande;
import com.groupeisi.ecommercegraphql.service.ICommandeService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class CommandeGraphQLController {
    private final ICommandeService commandeService;

    @MutationMapping
    public Commande saveCommande(@Argument CommandeRequestDto commande){
       return commandeService.createCommande(commande);
    }

    @MutationMapping
    public Commande updateCommande(@Argument Long id,@Argument CommandeRequestDto commande){
        return commandeService.updateCommande(id, commande);
    }

    @QueryMapping
    public Commande commandeById(@Argument Long id){
        return commandeService.findById(id);
    }

    @QueryMapping
    public List<Commande> listCommandes(){
        return commandeService.findAll();
    }
}
