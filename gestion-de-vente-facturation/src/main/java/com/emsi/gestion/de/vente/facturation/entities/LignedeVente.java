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
    private int Quantite;
    private Double prixUnitaire;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    Produit produit;

    @ManyToOne
    @MapsId("venteId")
    @JoinColumn(name = "vente_id")
    Vente vente;

    public LignedeVente(LigneDeVenteKey id, int Quantite , Double prixUnitaire) {
        Id = id;
        this.Quantite = Quantite;
        this.prixUnitaire = prixUnitaire;
    }
}
