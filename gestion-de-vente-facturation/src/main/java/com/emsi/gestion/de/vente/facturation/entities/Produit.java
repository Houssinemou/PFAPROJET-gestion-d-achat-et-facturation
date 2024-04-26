package com.emsi.gestion.de.vente.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nom;
    private String Description;
    private Double Prix;
    private int QuantitéEnStock;
    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<LignedeVente> ligneDeVente = new HashSet<>();
}
