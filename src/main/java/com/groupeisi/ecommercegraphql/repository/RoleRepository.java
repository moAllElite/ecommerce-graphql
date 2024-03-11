package com.groupeisi.ecommercegraphql.repository;

import com.groupeisi.ecommercegraphql.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
