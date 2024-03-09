package com.groupeisi.ecommercegraphql.service;


import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import java.util.List;

public interface IProduitService {

     List<Produit> findAll();
     Produit findById(String  id);
     Produit save (ProduitRequestDto produitRequestDto);
     List<Produit> findAllByIdCategory(Long id);
     Produit update(String id,ProduitRequestDto produitRequestDto);
     void delete(String id);
}
