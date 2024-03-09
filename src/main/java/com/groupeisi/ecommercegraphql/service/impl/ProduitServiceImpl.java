package com.groupeisi.ecommercegraphql.service.impl;


import com.groupeisi.ecommercegraphql.mappers.ProduitMapper;
import com.groupeisi.ecommercegraphql.dto.ProduitRequestDto;
import com.groupeisi.ecommercegraphql.entities.Produit;
import com.groupeisi.ecommercegraphql.repository.ProduitRepository;
import com.groupeisi.ecommercegraphql.service.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements IProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(String id) {
        return produitRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Produit %s est introuvable", id)) );
    }

    @Override
    public Produit save(ProduitRequestDto produitRequestDto) {
        Produit produit =  produitMapper.toProduitEntity(produitRequestDto);
        produit.setIdProduit(UUID.randomUUID().toString());
       return produitRepository.save(produit)
       ;
    }

    @Override
    public List<Produit> findAllByIdCategory(Long id) {
        return produitRepository.findAllByCategorie_Id(id);
    }

    @Override
    public Produit update(String id,ProduitRequestDto produitRequestDto) throws RuntimeException{
        if(!produitRepository.existsById(id)) {
            throw new IllegalArgumentException(String.format("Produit %s est introuvable", id));
        }else{
            Produit produit =   produitMapper.toProduitEntity(produitRequestDto);
            produit.setIdProduit(id);
            return produitRepository.save(produit);
        }
    }

    @Override
    public void delete(String id) {
        produitRepository.deleteById(id);
    }
}
