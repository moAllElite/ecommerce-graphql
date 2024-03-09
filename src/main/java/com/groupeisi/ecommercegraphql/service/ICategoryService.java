package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.CategorieRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;

import java.util.List;

public interface ICategoryService {
    List<CategorieRequestDto> findAll();
    Categorie save (CategorieRequestDto categorieRequestDto);
    CategorieRequestDto findByIdCategory(Long id);
    CategorieRequestDto update(Long id,CategorieRequestDto    categorieRequestDto);
    void delete(Long id) ;
}
