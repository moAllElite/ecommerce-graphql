package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Commande  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy-HH:mm",iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dateCommande;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;
}
