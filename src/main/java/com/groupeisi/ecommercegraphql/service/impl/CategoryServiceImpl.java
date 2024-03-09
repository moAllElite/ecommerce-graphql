package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.CategorieRequestDto;
import com.groupeisi.ecommercegraphql.entities.Categorie;
import com.groupeisi.ecommercegraphql.mappers.CategorieMapper;
import com.groupeisi.ecommercegraphql.repository.CategorieRepository;
import com.groupeisi.ecommercegraphql.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategorieRepository   categorieRepository;
    private final CategorieMapper categorieMapper;

    @Override
    public List<CategorieRequestDto> findAll() {
        return categorieRepository.findAll()
                .stream()
                .map(categorieMapper::toCategorieRequestDto)
                .toList();
    }



    @Override
    public  Categorie   save(CategorieRequestDto categorieRequestDto) {
        return categorieRepository.save(
                categorieMapper.toCategorieEntity(
                        categorieRequestDto
                )
        );
    }

    @Override
    public CategorieRequestDto findByIdCategory(Long id) {
        return categorieRepository.findById(id)
                .map(categorieMapper::toCategorieRequestDto)
                .orElseThrow(()->new RuntimeException(String.format("Categorie %s est introuvable",id)));
    }

    @Override
    public CategorieRequestDto update(Long id, CategorieRequestDto categorieRequestDto) {
        if(categorieRepository.existsById(id)){
            return  categorieMapper.toCategorieRequestDto(
                    categorieRepository.save(
                    categorieMapper.toCategorieEntity(categorieRequestDto)
            )
            );
        }else{
            return null;
        }

    }

    @Override
    public void delete(Long id) throws RuntimeException {
       Categorie categorie =   categorieRepository.findById(id).
               orElseThrow(()-> new RuntimeException(String.format("Categorie %s est introuvable",id)));
        if(categorie!=null)
            categorieRepository.deleteById(id);
    }
}
