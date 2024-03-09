package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Produit {
    @Id
    private String  idProduit;
    private String designation;
    private String description;
    private double prix;
    private int quantite;
    private boolean selectionne;
    private  String photo;
    @ManyToOne
    private Categorie categorie;
}
