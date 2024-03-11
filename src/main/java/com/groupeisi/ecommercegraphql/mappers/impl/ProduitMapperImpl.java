package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;
import com.groupeisi.ecommercegraphql.entities.Produit;
import com.groupeisi.ecommercegraphql.mappers.CategorieMapper;
import com.groupeisi.ecommercegraphql.mappers.ProduitMapper;
import com.groupeisi.ecommercegraphql.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProduitMapperImpl implements ProduitMapper {
    private final ICategoryService categoryService;
    private final CategorieMapper categorieMapper;
    @Override
    public ProduitRequestDto toProduitRequestDto(Produit produit) {
        return     new ProduitRequestDto(
                produit.getIdProduit(),
                produit.getDesignation(),
                produit.getDescription(),
                produit.getPrix(),
                produit.getQuantite(),
                produit.isSelectionne(),
                produit.getPhoto(),
                produit.getCategorie().getId()
        );
    }

    @Override
    public Produit toProduitEntity(ProduitRequestDto produitRequestDto) {
        Produit produit = new Produit();
        produit.setIdProduit(produitRequestDto.idProduit());
        produit.setPrix(produitRequestDto.prix());
        //get category
        Categorie   category = categorieMapper.toCategorieEntity(
                categoryService.findByIdCategory(produitRequestDto.categoryId())
        );
        produit.setCategorie(category);
        produit.setPhoto(produitRequestDto.photo());
        produit.setDescription(produitRequestDto.description());
        produit.setDesignation(produitRequestDto.designation());
        produit.setPrix(produitRequestDto.prix());
        produit.setIdProduit(produitRequestDto.idProduit());
        return produit;
    }
}
