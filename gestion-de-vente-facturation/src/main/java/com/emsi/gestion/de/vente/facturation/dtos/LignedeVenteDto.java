package com.emsi.gestion.de.vente.facturation.dtos;

import com.emsi.gestion.de.vente.facturation.entities.LigneDeVenteKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LignedeVenteDto {
    private LigneDeVenteKey id;
    private int quantite;
    private Double prixUnitaire;
}
