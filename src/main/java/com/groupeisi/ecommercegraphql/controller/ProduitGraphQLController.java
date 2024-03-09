package com.groupeisi.ecommercegraphql.controller;

import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
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
    @QueryMapping(name = "listeProduits")
    public List<ProduitRequestDto> listeProduits() {
        return produitService.findAll();
    }
    @QueryMapping
    public ProduitRequestDto productById(@Argument String id){
        return produitService.findById(id);
    }

    @QueryMapping
    public List<ProduitRequestDto> listProductsByIdCatgory(@Argument Long id){
        return produitService.findAllByIdCategory(id);
    }

    @MutationMapping
    public Produit  saveProduct(@Argument ProduitRequestDto produit) {
        return produitService.save(produit);
    }


}
