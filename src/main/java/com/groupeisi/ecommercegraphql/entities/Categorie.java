package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String photo;
    private String description;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER)
    private List<Produit> produits;
}
