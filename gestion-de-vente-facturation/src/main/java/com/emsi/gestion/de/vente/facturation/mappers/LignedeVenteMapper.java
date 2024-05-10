package com.emsi.gestion.de.vente.facturation.mappers;

import com.emsi.gestion.de.vente.facturation.dtos.LignedeVenteDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.LignedeVente;
import com.emsi.gestion.de.vente.facturation.entities.Produit;

public class LignedeVenteMapper {
    public static LignedeVenteDto mapToLignedeVenteDto(LignedeVente lignedeVente){
        return new LignedeVenteDto(
                lignedeVente.getId(),
                lignedeVente.getQuantite(),
                lignedeVente.getPrixUnitaire()
        );
    }
    public static LignedeVente mapToLignedeVente(LignedeVenteDto lignedeVenteDto) {
        return new LignedeVente(
                lignedeVenteDto.getId(),
                lignedeVenteDto.getQuantite(),
                lignedeVenteDto.getPrixUnitaire()
        );
    }
}
