package com.emsi.gestion.de.vente.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LignedeVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int Quantité;
    private Double PrixUnitaire;

    @ManyToMany(mappedBy = "Lignedevente",fetch = FetchType.EAGER)
    private List<Vente>ventes=new ArrayList<>();
    @ManyToMany(mappedBy = "Lignedevente",fetch = FetchType.EAGER)
    private List<Produit> produits=new ArrayList<>();



}
