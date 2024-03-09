package com.groupeisi.ecommercegraphql;

import com.groupeisi.ecommercegraphql.entities.Categorie;
import com.groupeisi.ecommercegraphql.entities.Produit;
import com.groupeisi.ecommercegraphql.repository.CategorieRepository;
import com.groupeisi.ecommercegraphql.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class EcommerceGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceGraphqlApplication.class, args);
    }
    private final Random random = new Random();

    //@Bean
    CommandLineRunner commandLineRunner(CategorieRepository categorieRepository, ProduitRepository  produitRepository) {
        return args -> {

            List.of( "Computer","Print","Smartphone").forEach(cat->{
                new Categorie();
                Categorie categorie = Categorie.builder().
                        nom(cat)
                        .description("unkown")
                        .build();
                categorieRepository.save(categorie);
            });
            categorieRepository.findAll().forEach(category->{
               for(int i =0 ; i < 10; i++){
                   new Produit();
                   Produit produit = Produit
                           .builder()
                           .idProduit(UUID.randomUUID().toString())
                           .designation("Computer" + i)
                           .prix(1000 + Math.random() * 50000)
                           .quantite(random.nextInt(100))
                           .photo("Photo" + i)
                           .description("desc"+ i)
                           .selectionne(false)
                           .categorie(category)
                           .build();
                   produitRepository.save(produit);
               }
            });
        };
    }
}
