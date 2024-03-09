package com.groupeisi.ecommercegraphql.service.impl;


import com.groupeisi.ecommercegraphql.mappers.ProduitMapper;
import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import com.groupeisi.ecommercegraphql.repository.ProduitRepository;
import com.groupeisi.ecommercegraphql.service.ICategoryService;
import com.groupeisi.ecommercegraphql.service.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements IProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;
    private final ICategoryService categoryService;

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll() ;
    }

    @Override
    public Produit findById(String id) {
        return produitRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Produit %s est introuvable", id)) );
    }

    @Override
    public Produit save(ProduitRequestDto produitRequestDto) {

       return produitRepository.save(
               produitMapper.toProduit(produitRequestDto)
               )
       ;
    }

    @Override
    public List<Produit> findAllByIdCategory(Long id) {
        return produitRepository.findAllByCategorie_Id(id);
    }
}
