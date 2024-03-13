package com.groupeisi.ecommercegraphql.repository;

import com.groupeisi.ecommercegraphql.entities.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation,Long> {
    Optional<Validation> findByCode(String code);
}
