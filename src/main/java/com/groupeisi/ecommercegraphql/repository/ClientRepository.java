package com.groupeisi.ecommercegraphql.repository;

import com.groupeisi.ecommercegraphql.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
