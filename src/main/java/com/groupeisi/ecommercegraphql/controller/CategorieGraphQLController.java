package com.groupeisi.ecommercegraphql.controller;

import com.groupeisi.ecommercegraphql.dto.CategorieRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;
import com.groupeisi.ecommercegraphql.service.ICategoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CategorieGraphQLController {
    private final ICategoryService categoryService;

    public CategorieGraphQLController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @QueryMapping
    public CategorieRequestDto categoryById(@Argument Long id){
        return  categoryService.findByIdCategory(id);
    }
    @QueryMapping
    public List<CategorieRequestDto> categorieList(){
       return categoryService.findAll();
    }

    @MutationMapping
    public Categorie saveNewCategory(@Argument CategorieRequestDto categorie){
        return categoryService.save(categorie);
    }

    @MutationMapping
    public CategorieRequestDto updateCategory(@Argument   Long id, @Argument CategorieRequestDto categorie){
        return categoryService.update(id,categorie);
    }
    @MutationMapping
    public void deleteCategory(@Argument  Long  id){
         categoryService.delete(id);
    }
}
