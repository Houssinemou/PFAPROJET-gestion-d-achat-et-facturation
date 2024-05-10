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
    @EmbeddedId
    private LigneDeVenteKey Id;
    private int quantite;
    private Double prixUnitaire;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    Produit produit;

    @ManyToOne
    @MapsId("venteId")
    @JoinColumn(name = "vente_id")
    Vente vente;

    public LignedeVente(LigneDeVenteKey id, int quantite, Double prixUnitaire) {
        Id = id;
        quantite = quantite;
        prixUnitaire = prixUnitaire;
    }
}
