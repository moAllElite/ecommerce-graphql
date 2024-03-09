package com.groupeisi.ecommercegraphql.controller;

import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import com.groupeisi.ecommercegraphql.service.ICategoryService;
import com.groupeisi.ecommercegraphql.service.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProduitGraphQLController {
    private final IProduitService produitService;
    private final ICategoryService categoryService;
    @QueryMapping(name = "listeProduits")
    public List<Produit> listeProduits() {
        return produitService.findAll();
    }
    @QueryMapping
    public Produit productById(@Argument String id){
        return produitService.findById(id);
    }

    @QueryMapping
    public List<Produit> listProductsByIdCatgory(@Argument Long id){
        return produitService.findAllByIdCategory(id);
    }

    @MutationMapping
    public Produit  saveProduct(@Argument ProduitRequestDto produit) {
       Produit produitToSave=new Produit();
        //get Category
        //Categorie category= categoryService.findByIdCategory(produit.categorieId());
        //produitToSave.setCategorie(category);
/*
        produitToSave.setIdProduit(UUID.randomUUID().toString());
        produitToSave.setDescription(produit.description());
        produitToSave.setPhoto(produit.photo());
        produitToSave.setDesignation(produit.designation());
        produitToSave.setPrix(produit.prix());*/


        return produitService.save(produit);
    }


}
