package com.groupeisi.ecommercegraphql.service;


import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import java.util.List;

public interface IProduitService {

     List<ProduitRequestDto> findAll();
     ProduitRequestDto findById(String  id);
     Produit save (ProduitRequestDto produitRequestDto);
     List<ProduitRequestDto> findAllByIdCategory(Long id);
}
