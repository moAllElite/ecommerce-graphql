package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.CategorieRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;
import org.springframework.stereotype.Component;

@Component
public class CategorieMapperImpl implements CategorieMapper {
    @Override
    public Categorie toCategorieEntity(CategorieRequestDto categorieRequestDto) {
        Categorie categorie = new Categorie();
        categorie.setId(categorieRequestDto.id());
        categorie.setNom(categorieRequestDto.nom());
        categorie.setDescription(categorieRequestDto.description());
        categorie.setPhoto(categorieRequestDto.photo());
        return  categorie;
    }

    @Override
    public CategorieRequestDto toCategorieRequestDto(Categorie categorie) {
        return new CategorieRequestDto(
                categorie.getId(),
                categorie.getNom(),
                categorie.getPhoto(),
                categorie.getDescription()
        );
    }
}
