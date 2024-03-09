package com.groupeisi.ecommercegraphql.repository;

import com.groupeisi.ecommercegraphql.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
