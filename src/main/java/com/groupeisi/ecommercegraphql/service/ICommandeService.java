package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.CommandeRequestDto;
import com.groupeisi.ecommercegraphql.entities.Commande;

import java.util.List;

public interface ICommandeService {
    Commande createCommande(CommandeRequestDto commandeRequestDto);
    Commande findById(Long id);
    Commande updateCommande(Long id,CommandeRequestDto commandeRequestDto);
    void deleteCommande(Long id);
    List<Commande> findAll();
}
