package com.groupeisi.ecommercegraphql.repository;

import com.groupeisi.ecommercegraphql.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
